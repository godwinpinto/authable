package com.github.godwinpinto.authable.integration.testcase.totp;

import com.github.godwinpinto.authable.application.rest.totp.json.VerifyTOtpRequest;
import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import com.github.godwinpinto.authable.integration.support.TOtpCreateDbObjectsIT;
import com.github.godwinpinto.authable.integration.support.TestContainerSetupIT;
import com.github.godwinpinto.authable.orchestration.AuthableApplication;
import dev.samstevens.totp.code.CodeGenerator;
import dev.samstevens.totp.code.DefaultCodeGenerator;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.CodeGenerationException;
import dev.samstevens.totp.time.SystemTimeProvider;
import dev.samstevens.totp.time.TimeProvider;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = "spring.main.web-application-type=reactive",
    classes = AuthableApplication.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "5000000")
@Testcontainers
@ActiveProfiles("test")
@Import({TestContainerSetupIT.class})
@TestMethodOrder(OrderAnnotation.class)
class TOtpVerifyIT {
  private static final String URI = "/totp/verify";
  private static String validToken;
  private final String USER = "TEST_USER";
  private final String PASSWORD = "TEST_PASSWORD";
  private final String SYSTEM = "TEST_SYSTEM";
  @Autowired SystemUserMasterRepository systemUserMasterRepository;
  @Autowired SystemMasterRepository systemMasterRepository;
  @Autowired TOtpCryptoSPI tOtpCryptoSPI;
  @Autowired TOtpUserMasterSPI tOtpUserMasterSPI;

  @Qualifier("jwtUtilspi")
  @Autowired
  JWTUtilSPI jwtUtilSPI;

  @Autowired private TOtpSecretEncryption tOtpSecretEncryption;
  @Autowired private WebTestClient webTestClient;
  @LocalServerPort private int port;

  @PostConstruct
  public void initialise() {
    webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    UserDto userDto =
        UserDto.builder().username("TUA").systemId("SYS_A").roles(List.of(Role.ROLE_ADMIN)).build();
    validToken = jwtUtilSPI.generateToken(userDto);

    TOtpCreateDbObjectsIT tOtpCreateDbObjectsIT =
        new TOtpCreateDbObjectsIT(
            systemUserMasterRepository, systemMasterRepository, tOtpUserMasterSPI, tOtpCryptoSPI);
    tOtpCreateDbObjectsIT.loadData();
  }

  @Test
  @Order(1)
  void noToken_Test() {

    webTestClient
        .post()
        .uri(URI)
        .exchange()
        .expectStatus()
        .isUnauthorized()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  @Order(1)
  void badToken_Test() {
    String token =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(token))
        .exchange()
        .expectStatus()
        .isUnauthorized()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  @Order(1)
  void expiredToken_Test() {

    String token =
        "eyJhbGciOiJIUzUxMiJ9.eyJzeXN0ZW1JZCI6Ik5FVEJLIiwicm9sZSI6WyJST0xFX0FETUlOIl0sInN1YiI6IjAzODJiOWRlLWZlY2EtNDk0Ny1iYTcyLWM3NWNkNTJlNTFmMCIsImlhdCI6MTY4MTQ5MjMzNSwiZXhwIjoxNjgxNDk1OTM1fQ.-YJF3ZPaFjk8FIfq-O_q6bSYPDxWJKc0_P1s12-9brjqrJ_LMD5ncNSRWnJZvg94MnK42EscjHMHtIsemVai9g";
    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(token))
        .exchange()
        .expectStatus()
        .isUnauthorized()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  @Order(1)
  void requestFieldsNotSet_Test() {
    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("400");
  }

  @Test
  @Order(1)
  void requestFieldsNull_Test() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("400");
  }

  @Test
  @Order(1)
  void requestFieldsUserNull_Test() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setOtp("123456");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("400");
  }

  @Test
  @Order(1)
  void requestFieldsOtpNull_Test() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setUserId("_VERIFY_UA1");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("400");
  }

  @ParameterizedTest
  @CsvSource({"_VERIFY_UD,405", "_VERIFY_UN,404", "_VERIFY_UA1,200"})
  @Order(5)
  void userDisabledAndInActiveAndSuccess_Test(String userId, String statusCode) throws CodeGenerationException {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setUserId(userId);

    String otp = generateValidCode(verifyTOtpRequest.getUserId());
    verifyTOtpRequest.setOtp(otp);

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo(statusCode);
  }


  @Test
  @Order(7)
  void userActiveFailedOtp_Test() throws CodeGenerationException {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setUserId("_VERIFY_UA1");

    String otp = "123456";
    verifyTOtpRequest.setOtp(otp);

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("401");
  }

  @Test
  @Order(8)
  void userReActivatedForNext_Test() throws CodeGenerationException {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setUserId("_VERIFY_UA1");

    String otp = generateValidCode(verifyTOtpRequest.getUserId());
    verifyTOtpRequest.setOtp(otp);

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()

        .jsonPath("$.statusCode")
        .isEqualTo("200").consumeWith(System.out::println);
  }

  @Test
  @Order(14)
  void authUserDisabledFailAttemptsInSystem_InDb_Test() {

    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest();
    verifyTOtpRequest.setUserId("_VERIFY_UA1");

    String otp = "12345";
    verifyTOtpRequest.setOtp(otp);

    for (int i = 0; i < 5; i++) {

      webTestClient
          .post()
          .uri(URI)
          .headers(headers -> headers.setBearerAuth(validToken))
          .bodyValue(verifyTOtpRequest)
          .exchange()
          .expectStatus()
          .isOk()
          .expectBody()
          .consumeWith(System.out::println);
    }
    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(verifyTOtpRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("405")
        .jsonPath("$.statusDescription")
        .isEqualTo("Access is disabled for the user");
  }

  /* @Test
  @Order(8)
  void userNew_Test() {
    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("UXX");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .consumeWith(System.out::println)
        .jsonPath("$.statusCode")
        .isEqualTo("404");
  }*/

  private String generateValidCode(String userId) throws CodeGenerationException {

    TOtpUserMasterDto dto =
        tOtpUserMasterSPI
            .findById(StringUtils.rightPad("SYS_A" + userId, 50, ApplicationConstants.DB_PAD_CHAR))
            .block();

    String salt = tOtpSecretEncryption.decrypt("SYS_A" + userId, dto.getUserSecret());
    TimeProvider timeProvider = new SystemTimeProvider();
    CodeGenerator codeGenerator = new DefaultCodeGenerator();
    String code = generateCode(HashingAlgorithm.SHA1, salt, timeProvider.getTime());

    return code;
  }

  private String generateCode(HashingAlgorithm algorithm, String secret, long time)
      throws CodeGenerationException {
    long currentBucket = Math.floorDiv(time, 30);
    DefaultCodeGenerator g = new DefaultCodeGenerator(algorithm);
    return g.generate(secret, currentBucket);
  }
}
