package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpCreateNewDto;
import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import java.time.LocalDateTime;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = {TOtpCreateSecretHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpCreateSecretHelperTest {
  @MockBean private FetchPrincipalComponent fetchPrincipalComponent;

  @Autowired private TOtpCreateSecretHelper tOtpCreateSecretHelper;

  @MockBean private TOtpCryptoSPI tOtpCryptoSPI;

  @MockBean private TOtpUserMasterSPI tOtpUserMasterSPI;

  @Test
  void isAllowedToReset_Disabled_Test() {
    TOtpUserMasterDto user = TOtpUserMasterDto.builder().status("D").userId("1234").build();
    StepVerifier.create(tOtpCreateSecretHelper.isAllowedToReset(user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Your TOTP is disabled. Contact administrator"))
        .verify();

    user.setStatus("A");
    StepVerifier.create(tOtpCreateSecretHelper.isAllowedToReset(user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage()
                        .equals(
                            "You already have an active TOTP. "
                                + "Unsubscribe first to generate new one or contact administrator"))
        .verify();

    user.setStatus("X");
    StepVerifier.create(tOtpCreateSecretHelper.isAllowedToReset(user))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Unknown error. Contact Administrator."))
        .verify();

    user.setStatus("N");
    StepVerifier.create(tOtpCreateSecretHelper.isAllowedToReset(user))
        .assertNext(
            tOtpUserMasterDto -> {
              assertEquals(tOtpUserMasterDto.getUserId(), user.getUserId());
            })
        .verifyComplete();
  }

  @Test
  void updateDbToReset_Test() {
    Mono<Long> mono = mock(Mono.class);
    when(mono.flatMap(Mockito.<Function<Long, Mono<Object>>>any())).thenReturn(null);
    when(tOtpUserMasterSPI.updateEntity(Mockito.<TOtpUserMasterDto>any())).thenReturn(mono);
    when(tOtpCryptoSPI.generateSecretKey(Mockito.<String>any()))
        .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
    doNothing().when(user).setCreationDateTime(Mockito.<LocalDateTime>any());
    doNothing().when(user).setCreationId(Mockito.<String>any());
    doNothing().when(user).setInvalidAttemptDateTime(Mockito.<LocalDateTime>any());
    doNothing().when(user).setLastLoginDateTime(Mockito.<LocalDateTime>any());
    doNothing().when(user).setLockedDateTime(Mockito.<LocalDateTime>any());
    doNothing().when(user).setModificationDateTime(Mockito.<LocalDateTime>any());
    doNothing().when(user).setModificationId(Mockito.<String>any());
    doNothing().when(user).setNoOfAttempts(anyShort());
    doNothing().when(user).setStatus(Mockito.<String>any());
    doNothing().when(user).setUserSecret(Mockito.<String>any());
    assertNull(tOtpCreateSecretHelper.updateDbToReset("42", user));
    verify(tOtpUserMasterSPI).updateEntity(Mockito.<TOtpUserMasterDto>any());
    verify(mono).flatMap(Mockito.<Function<Long, Mono<Object>>>any());
    verify(tOtpCryptoSPI).generateSecretKey(Mockito.<String>any());
    verify(user).setCreationDateTime(Mockito.<LocalDateTime>any());
    verify(user).setCreationId(Mockito.<String>any());
    verify(user).setInvalidAttemptDateTime(Mockito.<LocalDateTime>any());
    verify(user).setLastLoginDateTime(Mockito.<LocalDateTime>any());
    verify(user).setLockedDateTime(Mockito.<LocalDateTime>any());
    verify(user).setModificationDateTime(Mockito.<LocalDateTime>any());
    verify(user).setModificationId(Mockito.<String>any());
    verify(user).setNoOfAttempts(anyShort());
    verify(user).setStatus(Mockito.<String>any());
    verify(user).setUserSecret(Mockito.<String>any());
  }

  @Test
  void updateDbToReset_Update_Test() {
    TOtpUserMasterDto userDto = TOtpUserMasterDto.builder().status("N").userId("1234").build();

    doReturn(Mono.just(1L)).when(this.tOtpUserMasterSPI).updateEntity(any(TOtpUserMasterDto.class));

    when(tOtpCryptoSPI.generateSecretKey(Mockito.<String>any()))
        .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    when(tOtpCryptoSPI.getPlainTextSecret(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    TOtpCreateNewDto response =
        TOtpCreateNewDto.builder()
            .statusCode("200")
            .statusDescription("TOTP generated successfully.")
            .secretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")
            .build();

    StepVerifier.create(tOtpCreateSecretHelper.updateDbToReset("SYSTEM_USER", userDto))
        .assertNext(
            res -> {
              assertEquals(response.getSecretKey(), res.getSecretKey());
            })
        .verifyComplete();

    doReturn(Mono.just(0L)).when(this.tOtpUserMasterSPI).updateEntity(any(TOtpUserMasterDto.class));

    StepVerifier.create(tOtpCreateSecretHelper.updateDbToReset("SYSTEM_USER", userDto))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Unknown error. Contact Administrator."))
        .verify();
  }

  @Test
  void fallbackMethod_Test() {

    NonFatalException nfe = new NonFatalException("300", "Sample Exception");

    Exception e = new Exception("Sample Other Exception");

    StepVerifier.create(tOtpCreateSecretHelper.fallbackMethod(nfe))
        .assertNext(
            tOtpCreateNewDto -> {
              assertEquals(tOtpCreateNewDto.getStatusDescription(), nfe.getMessage());
              assertEquals(tOtpCreateNewDto.getStatusCode(), nfe.getErrCode());
            })
        .verifyComplete();

    StepVerifier.create(tOtpCreateSecretHelper.fallbackMethod(e))
        .assertNext(
            tOtpCreateNewDto -> {
              assertEquals(tOtpCreateNewDto.getStatusDescription(), "Unknown error occurred");
            })
        .verifyComplete();
  }

  @Test
  void createNewRecord_Test() {

    doReturn(Mono.empty()).when(this.fetchPrincipalComponent).getAuthDetails();
    StepVerifier.create(tOtpCreateSecretHelper.createNewRecord("TEST_SYSTEM", "TEST_USER"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Unable to fetch login details"))
        .verify();

    UserDto userDto = new UserDto();
    userDto.setUsername("TEST_USER");
    userDto.setSystemId("TEST_SYSTEM");
    doReturn(Mono.just(userDto)).when(this.fetchPrincipalComponent).getAuthDetails();

    doReturn("SAMPLE_SECRET").when(tOtpCryptoSPI).generateSecretKey(any());

    doReturn(Mono.just(true)).when(tOtpUserMasterSPI).createEntity(any());

    StepVerifier.create(tOtpCreateSecretHelper.createNewRecord("TEST_SYSTEM", "TEST_USER"))
        .assertNext(
            tOtpCreateNewDto -> {
              assertEquals(tOtpCreateNewDto.getStatusDescription(), "TOTP generated successfully.");
            })
        .verifyComplete();

    doReturn(Mono.just(false)).when(tOtpUserMasterSPI).createEntity(any());

    StepVerifier.create(tOtpCreateSecretHelper.createNewRecord("TEST_SYSTEM", "TEST_USER"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Unknown error. Contact Administrator."))
        .verify();
  }

  @Test
  void createNewRecord_NullInsertFailed_Test() {

    UserDto userDto = new UserDto();
    userDto.setUsername("TEST_USER");
    userDto.setSystemId("TEST_SYSTEM");
    doReturn(Mono.just(userDto)).when(this.fetchPrincipalComponent).getAuthDetails();

    doReturn("SAMPLE_SECRET").when(tOtpCryptoSPI).generateSecretKey(any());

    doReturn(Mono.empty()).when(tOtpUserMasterSPI).createEntity(any());

    doReturn(Mono.just(userDto)).when(this.fetchPrincipalComponent).getAuthDetails();

    StepVerifier.create(tOtpCreateSecretHelper.createNewRecord("TEST_SYSTEM", "TEST_USER"))
        .expectErrorMatches(
            e ->
                e instanceof NonFatalException
                    && e.getMessage().equals("Unknown error. Contact Administrator."))
        .verify();
  }
}
