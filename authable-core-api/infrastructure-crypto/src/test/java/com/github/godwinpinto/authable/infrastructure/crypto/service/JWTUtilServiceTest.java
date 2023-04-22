package com.github.godwinpinto.authable.infrastructure.crypto.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ContextConfiguration(classes = {JWTUtilService.class})
@ExtendWith(SpringExtension.class)
@TestPropertySource(
    properties = {
      "infrastructure-crypto.jwt.secret=ThisIsSecretForJWTHS512SignatureAlgorithmThatMUSTHave64ByteLength",
      "infrastructure-crypto.jwt.expiry=3600"
    })
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JWTUtilServiceTest {
  String token;
  @Autowired private JWTUtilService jWTUtilService;

  @BeforeAll
  void createSampleToken() {
    UserDto userDto =
        UserDto.builder().username("USER").systemId("TEST").roles(List.of(Role.ROLE_ADMIN)).build();
    token = jWTUtilService.generateToken(userDto);
  }

  @Test
  void testGenerateTokenWithNullUser() {
    assertThrows(JwtException.class, () -> jWTUtilService.generateToken(null));
  }

  @Test
  void testGenerateTokenWithNullFields() {
    UserDto userDto = new UserDto();
    assertThrows(JwtException.class, () -> jWTUtilService.generateToken(userDto));

    userDto.setUsername("USER");

    assertThrows(JwtException.class, () -> jWTUtilService.generateToken(userDto));

    userDto.setSystemId("TEST");
    assertThrows(JwtException.class, () -> jWTUtilService.generateToken(userDto));

    userDto.setRoles(List.of(Role.ROLE_ADMIN));
    assertDoesNotThrow(() -> jWTUtilService.generateToken(userDto));
  }

  @Test
  void testGetAllClaimsFromToken() {
    Claims claim = jWTUtilService.getAllClaimsFromToken(this.token);
    assertEquals(claim.getSubject(), "USER");
  }

  @Test
  void testGetUsernameFromToken() {
    String username = jWTUtilService.getUsernameFromToken(this.token);
    assertEquals(username, "USER");
  }

  @Test
  void testIsTokenNotExpired() {
    boolean isValidToken = jWTUtilService.validateToken(this.token);
    assertEquals(true, isValidToken);
  }

  @Test
  void testGetAllClaimsFromInvalidToken() {
    assertThrows(JwtException.class, () -> jWTUtilService.getAllClaimsFromToken("Token"));
  }

  @Test
  void testRolesFromClaim() {
    List<String> lstRoles = jWTUtilService.rolesFromClaim(token);
    assertEquals("ROLE_ADMIN", lstRoles.get(0));
  }

  @Test
  void testExpiredJwt() {

    String expiredToken =
        "eyJhbGciOiJIUzUxMiJ9.eyJzeXN0ZW1JZCI6Ik5FVEJLIiwicm9sZSI6WyJST0xFX0FETUlOIl0sInN1YiI6IjAzODJiOWRlLWZlY2EtNDk0Ny1iYTcyLWM3NWNkNTJlNTFmMCIsImlhdCI6MTY4MTQ5MjMzNSwiZXhwIjoxNjgxNDk1OTM1fQ.-YJF3ZPaFjk8FIfq-O_q6bSYPDxWJKc0_P1s12-9brjqrJ_LMD5ncNSRWnJZvg94MnK42EscjHMHtIsemVai9g";

    assertThrows(ExpiredJwtException.class, () -> jWTUtilService.validateToken(expiredToken));
  }

  @Test
  void shortKeyTest() {
    ReflectionTestUtils.setField(jWTUtilService, "secret", "SHORTKEYFORJWT");
    assertThrows(JwtException.class, () -> jWTUtilService.init());
  }

  @Test
  void validateToken_BranchUnitTest_Test() {
    JWTUtilService jwtUtilService2 = spy(new JWTUtilService());
    doReturn(DateTimeUtils.addDays(DateTimeUtils.getCurrentDate(), -1))
        .when(jwtUtilService2)
        .getExpirationDateFromToken(anyString());
    assertEquals(false, jwtUtilService2.validateToken("TEST_TOKEN"));
  }
}
