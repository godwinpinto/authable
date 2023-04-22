package com.github.godwinpinto.authable.domain.auth.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemMasterSPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemUserMasterSPI;
import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = {"domain.auth.max-failed-login-attempts=5"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {
  @Mock SystemMasterSPI systemMasterSPI;

  @Mock JWTUtilSPI jwtUtilSPI;

  @Mock CryptoAlgorithmsSPI cryptoAlgorithmsSPI;

  @Mock SystemUserMasterSPI systemUserMasterSPI;
  SystemUserMasterDto userMasterDto;
  SystemMasterDto systemMasterDto;
  @InjectMocks private UserService userService;

  @BeforeEach
  void setUpSystemUserMasterDto() {
    userMasterDto = new SystemUserMasterDto();
    userMasterDto.setUserName("TEST_USER");
    userMasterDto.setNoOfAttempts((short) 0);
    userMasterDto.setAccessId("TEST_ACCESS_ID");
    userMasterDto.setStatus("A");
    userMasterDto.setSystemId("TEST_SYSTEM");
    userMasterDto.setUserFullName("GODWIN");
    userMasterDto.setUserSecret("PASSWORD");

    systemMasterDto = new SystemMasterDto();
    systemMasterDto.setSystemId("TEST_SYSTEM");
    systemMasterDto.setStatus("A");
  }

  @Test
  public void findByUsernameNoSystemUserTest() {
    doReturn(Mono.empty()).when(this.systemUserMasterSPI).findById(anyString());
    StepVerifier.create(userService.findByUsername("TEST")).verifyComplete();
  }

  @Test
  void findByUsernameUserExistsButDisabledTest() {

    userMasterDto.setStatus("D");
    doReturn(Mono.just(userMasterDto)).when(this.systemUserMasterSPI).findById(anyString());

    StepVerifier.create(userService.findByUsername("TEST_ACCESS_ID"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("User access is inactive or disabled"))
        .verify();
  }

  @Test
  void findByUsernameUserExistsTest() {

    doReturn(Mono.just(userMasterDto)).when(this.systemUserMasterSPI).findById(anyString());

    StepVerifier.create(userService.findByUsername("TEST_ACCESS_ID"))
        .assertNext(
            userDto -> {
              assertEquals(userDto.getUsername(), userMasterDto.getAccessId());
            })
        .verifyComplete();
  }

  @Test
  void isSystemNotInDatabaseTest() {

    doReturn(Mono.empty()).when(this.systemMasterSPI).findById(anyString());
    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("The system is not in active status"))
        .verify();
  }

  @Test
  void isSystemInActiveOrDisabledTest() {
    systemMasterDto.setStatus("N");
    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("System access is disabled"))
        .verify();

    systemMasterDto.setStatus("D");
    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());
    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("System access is disabled"))
        .verify();
  }

  @Test
  void authenticate_userNotFoundInSystemTest() {
    systemMasterDto.setStatus("A");

    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());

    doReturn(Mono.empty())
        .when(this.systemUserMasterSPI)
        .findBySystemUser(anyString(), anyString());

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException && e.getMessage().equals("No User found for system"))
        .verify();
  }

  @Test
  void authenticate_userInActiveInSystemTest() {
    systemMasterDto.setStatus("A");
    userMasterDto.setStatus("N");
    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());

    doReturn(Mono.just(userMasterDto))
        .when(this.systemUserMasterSPI)
        .findBySystemUser(anyString(), anyString());

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Your access is inactive or disabled"))
        .verify();

    userMasterDto.setStatus("D");

    doReturn(Mono.just(userMasterDto))
        .when(this.systemUserMasterSPI)
        .findBySystemUser(anyString(), anyString());

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Your access is inactive or disabled"))
        .verify();
  }

  @Test
  void authenticate_PasswordIsCorrectTest() {
    systemMasterDto.setStatus("A");
    userMasterDto.setStatus("A");
    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());

    doReturn(Mono.just(userMasterDto))
        .when(this.systemUserMasterSPI)
        .findBySystemUser(anyString(), anyString());

    doReturn("PASSWORD")
        .when(this.cryptoAlgorithmsSPI)
        .generateHashFromSecret(anyString(), anyString(), anyString());

    doReturn(Mono.just(1L)).when(this.systemUserMasterSPI).updateLoginSuccess(anyString(), any());

    doReturn("TOKEN").when(this.jwtUtilSPI).generateToken(any());

    doReturn(DateTimeUtils.getCurrentDate())
        .when(this.jwtUtilSPI)
        .getExpirationDateFromToken(anyString());

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .assertNext(
            userDtoNew -> {
              assertEquals(userDtoNew.getUsername(), userMasterDto.getAccessId());
            })
        .verifyComplete();
  }

  @Test
  void authenticate_PasswordIsInCorrectTest() {
    systemMasterDto.setStatus("A");
    userMasterDto.setStatus("A");
    doReturn(Mono.just(systemMasterDto)).when(this.systemMasterSPI).findById(anyString());

    doReturn(Mono.just(userMasterDto))
        .when(this.systemUserMasterSPI)
        .findBySystemUser(anyString(), anyString());

    doReturn("PASSWORD1")
        .when(this.cryptoAlgorithmsSPI)
        .generateHashFromSecret(anyString(), anyString(), anyString());

    doReturn(Mono.just(1L))
        .when(this.systemUserMasterSPI)
        .updateInvalidAttempt(anyString(), any(), any());

    ReflectionTestUtils.setField(this.userService, "maxFailedAttempts", 5);

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Invalid Credentials"))
        .verify();

    doReturn(Mono.just(1L)).when(this.systemUserMasterSPI).updateDisable(anyString(), any(), any());

    userMasterDto.setNoOfAttempts((short) 4);

    StepVerifier.create(userService.authenticate("TEST_SYSTEM", "TEST_USER", "PASSWORD"))
        .expectErrorMatches(
            e -> e instanceof NonFatalException && e.getMessage().equals("Account has been locked"))
        .verify();
  }

  @Test
  void getUsernameFromTokenTest() {
    doReturn("TOKEN").when(this.jwtUtilSPI).getUsernameFromToken(any());

    assertDoesNotThrow(() -> userService.getUsernameFromToken("TEST"));
  }

  @Test
  void validateTokenTest() {
    doReturn(true).when(this.jwtUtilSPI).validateToken(any());
    assertTrue(userService.validateToken("TOKEN"));
  }

  @Test
  void getClaimsTest() {
    doReturn(new HashMap<String, Object>()).when(this.jwtUtilSPI).getClaims(any());
    assertDoesNotThrow(() -> userService.getClaims("TOKEN"));
  }
}
