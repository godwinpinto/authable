package com.github.godwinpinto.authable.infrastructure.crypto.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JWTUtilService.class})
@ExtendWith(SpringExtension.class)
class JWTUtilServiceTest {
    @Autowired
    private JWTUtilService jWTUtilService;

    /**
     * Method under test: {@link JWTUtilService#init()}
     */
    @Test
    void testInit() {
        assertThrows(RuntimeException.class, () -> jWTUtilService.init());
    }

    /**
     * Method under test: {@link JWTUtilService#getAllClaimsFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllClaimsFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.getAllClaimsFromToken("ABC123");
    }

    /**
     * Method under test: {@link JWTUtilService#getAllClaimsFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllClaimsFromToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.getAllClaimsFromToken("Token");
    }

    /**
     * Method under test: {@link JWTUtilService#getUsernameFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsernameFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getUsernameFromToken(JWTUtilService.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.getUsernameFromToken("ABC123");
    }

    /**
     * Method under test: {@link JWTUtilService#getExpirationDateFromToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetExpirationDateFromToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getExpirationDateFromToken(JWTUtilService.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.getExpirationDateFromToken("ABC123");
    }

    /**
     * Method under test: {@link JWTUtilService#generateToken(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "${infrastructure-crypto.jwt.expiry}"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Long.parseLong(Long.java:697)
        //       at java.lang.Long.parseLong(Long.java:836)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.doGenerateToken(JWTUtilService.java:66)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.generateToken(JWTUtilService.java:62)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.generateToken(new UserDto());
    }

    /**
     * Method under test: {@link JWTUtilService#generateToken(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.github.godwinpinto.authable.domain.auth.dto.UserDto.getRoles()" because "userDto" is null
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.generateToken(JWTUtilService.java:60)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.generateToken(null);
    }

    /**
     * Method under test: {@link JWTUtilService#generateToken(UserDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "${infrastructure-crypto.jwt.expiry}"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Long.parseLong(Long.java:697)
        //       at java.lang.Long.parseLong(Long.java:836)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.doGenerateToken(JWTUtilService.java:66)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.generateToken(JWTUtilService.java:62)
        //   See https://diff.blue/R013 to resolve this issue.

        UserDto userDto = mock(UserDto.class);
        when(userDto.getSystemId()).thenReturn("42");
        when(userDto.getUsername()).thenReturn("janedoe");
        when(userDto.getRoles()).thenReturn(new ArrayList<>());
        jWTUtilService.generateToken(userDto);
    }

    /**
     * Method under test: {@link JWTUtilService#validateToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getExpirationDateFromToken(JWTUtilService.java:50)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.isTokenExpired(JWTUtilService.java:54)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.validateToken(JWTUtilService.java:80)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.validateToken("ABC123");
    }

    /**
     * Method under test: {@link JWTUtilService#rolesFromClaim(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRolesFromClaim() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: signing key cannot be null.
        //       at io.jsonwebtoken.lang.Assert.notNull(Assert.java:82)
        //       at io.jsonwebtoken.impl.DefaultJwtParserBuilder.setSigningKey(DefaultJwtParserBuilder.java:165)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.getAllClaimsFromToken(JWTUtilService.java:39)
        //       at com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService.rolesFromClaim(JWTUtilService.java:84)
        //   See https://diff.blue/R013 to resolve this issue.

        jWTUtilService.rolesFromClaim("ABC123");
    }
}

