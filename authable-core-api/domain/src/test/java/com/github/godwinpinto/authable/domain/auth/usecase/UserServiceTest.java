package com.github.godwinpinto.authable.domain.auth.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#findByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByUsername() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String accessId = "";

        // Act
        Mono<UserDto> actualFindByUsernameResult = this.userService.findByUsername(accessId);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserService#authenticate(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthenticate() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String systemId = "";
        String userId = "";
        String password = "";

        // Act
        Mono<UserDto> actualAuthenticateResult = this.userService.authenticate(systemId, userId, password);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserService#getUsernameFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI.getUsernameFromToken(String)" because "this.jwtUtilspi" is null
        //       at com.github.godwinpinto.authable.domain.auth.usecase.UserService.getUsernameFromToken(UserService.java:148)
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserService(null, null, mock(CryptoAlgorithmsSPI.class), null)).getUsernameFromToken("ABC123");
    }

    /**
     * Method under test: {@link UserService#getUsernameFromToken(String)}
     */
    @Test
    void testGetUsernameFromToken2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        JWTUtilSPI jwtUtilspi = mock(JWTUtilSPI.class);
        when(jwtUtilspi.getUsernameFromToken(Mockito.<String>any())).thenReturn("janedoe");
        assertEquals("janedoe",
                (new UserService(null, null, mock(CryptoAlgorithmsSPI.class), jwtUtilspi)).getUsernameFromToken("ABC123"));
        verify(jwtUtilspi).getUsernameFromToken(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserService#validateToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI.validateToken(String)" because "this.jwtUtilspi" is null
        //       at com.github.godwinpinto.authable.domain.auth.usecase.UserService.validateToken(UserService.java:153)
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserService(null, null, mock(CryptoAlgorithmsSPI.class), null)).validateToken("ABC123");
    }

    /**
     * Method under test: {@link UserService#validateToken(String)}
     */
    @Test
    void testValidateToken2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        JWTUtilSPI jwtUtilspi = mock(JWTUtilSPI.class);
        when(jwtUtilspi.validateToken(Mockito.<String>any())).thenReturn(true);
        assertTrue((new UserService(null, null, mock(CryptoAlgorithmsSPI.class), jwtUtilspi)).validateToken("ABC123"));
        verify(jwtUtilspi).validateToken(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserService#validateToken(String)}
     */
    @Test
    void testValidateToken3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        JWTUtilSPI jwtUtilspi = mock(JWTUtilSPI.class);
        when(jwtUtilspi.validateToken(Mockito.<String>any())).thenReturn(false);
        assertFalse((new UserService(null, null, mock(CryptoAlgorithmsSPI.class), jwtUtilspi)).validateToken("ABC123"));
        verify(jwtUtilspi).validateToken(Mockito.<String>any());
    }

    /**
     * Method under test: {@link UserService#getClaims(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetClaims() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI.getClaims(String)" because "this.jwtUtilspi" is null
        //       at com.github.godwinpinto.authable.domain.auth.usecase.UserService.getClaims(UserService.java:158)
        //   See https://diff.blue/R013 to resolve this issue.

        (new UserService(null, null, mock(CryptoAlgorithmsSPI.class), null)).getClaims("ABC123");
    }

    /**
     * Method under test: {@link UserService#getClaims(String)}
     */
    @Test
    void testGetClaims2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.domain.auth.usecase.UserService.maxFailedAttempts
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        JWTUtilSPI jwtUtilspi = mock(JWTUtilSPI.class);
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        when(jwtUtilspi.getClaims(Mockito.<String>any())).thenReturn(stringObjectMap);
        Map<String, Object> actualClaims = (new UserService(null, null, mock(CryptoAlgorithmsSPI.class), jwtUtilspi))
                .getClaims("ABC123");
        assertSame(stringObjectMap, actualClaims);
        assertTrue(actualClaims.isEmpty());
        verify(jwtUtilspi).getClaims(Mockito.<String>any());
    }
}

