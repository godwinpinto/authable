package com.github.godwinpinto.authable.integration.testcase.totp;

import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import com.github.godwinpinto.authable.integration.support.TOtpCreateDbObjectsIT;
import com.github.godwinpinto.authable.integration.support.TestContainerSetupIT;
import com.github.godwinpinto.authable.orchestration.AuthableApplication;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
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
class GetUserStatusIT {
  private static final String URI = "/totp/status";
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

  @Autowired private WebTestClient webTestClient;
  @LocalServerPort private int port;

  @PostConstruct
  public void initialise() {
    webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    UserDto userDto =
        UserDto.builder().username("UA").systemId("SYS_A").roles(List.of(Role.ROLE_ADMIN)).build();
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
  @Order(2)
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
  @Order(3)
  void requestFieldsNotSet_Test() {
    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  @Order(3)
  void requestFieldsNull_Test() {
    GenericRequest genericRequest = new GenericRequest();

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isBadRequest()
        .expectBody()
        .consumeWith(System.out::println);
  }

  @Test
  @Order(4)
  void userNotInDB_Test() {
    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("UA5");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.statusCode")
        .isEqualTo("404")
        .consumeWith(System.out::println);
  }

  @Test
  @Order(5)
  void userDisabled_Test() {
    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("UD");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.statusCode")
        .isEqualTo("423")
        .consumeWith(System.out::println);
  }

  @Test
  @Order(6)
  void userInActive_Test() {
    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("UN");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.statusCode")
        .isEqualTo("404")
        .consumeWith(System.out::println);
  }

  @Test
  @Order(7)
  void userActive_Test() {
    GenericRequest genericRequest = new GenericRequest();
    genericRequest.setUserId("UA");

    webTestClient
        .post()
        .uri(URI)
        .headers(headers -> headers.setBearerAuth(validToken))
        .bodyValue(genericRequest)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.statusCode")
        .isEqualTo("200")
        .consumeWith(System.out::println);
  }
}
