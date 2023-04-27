package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService;
import io.jsonwebtoken.impl.DefaultClaims;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JWTUtilAdapter.class})
@ExtendWith(SpringExtension.class)
class JWTUtilAdapterTest {
  @Autowired private JWTUtilAdapter jWTUtilAdapter;

  @MockBean private JWTUtilService jWTUtilService;

  /** Method under test: {@link JWTUtilAdapter#getUsernameFromToken(String)} */
  @Test
  void testGetUsernameFromToken() {
    when(jWTUtilService.getUsernameFromToken(Mockito.<String>any())).thenReturn("janedoe");
    assertEquals("janedoe", jWTUtilAdapter.getUsernameFromToken("ABC123"));
    verify(jWTUtilService).getUsernameFromToken(Mockito.<String>any());
  }

  /** Method under test: {@link JWTUtilAdapter#validateToken(String)} */
  @Test
  void testValidateToken() {
    when(jWTUtilService.validateToken(Mockito.<String>any())).thenReturn(true);
    assertTrue(jWTUtilAdapter.validateToken("ABC123"));
    verify(jWTUtilService).validateToken(Mockito.<String>any());
  }

  /** Method under test: {@link JWTUtilAdapter#validateToken(String)} */
  @Test
  void testValidateToken2() {
    when(jWTUtilService.validateToken(Mockito.<String>any())).thenReturn(false);
    assertFalse(jWTUtilAdapter.validateToken("ABC123"));
    verify(jWTUtilService).validateToken(Mockito.<String>any());
  }

  /** Method under test: {@link JWTUtilAdapter#getClaims(String)} */
  @Test
  void testGetClaims() {
    DefaultClaims defaultClaims = new DefaultClaims();
    when(jWTUtilService.getAllClaimsFromToken(Mockito.<String>any())).thenReturn(defaultClaims);
    Map<String, Object> actualClaims = jWTUtilAdapter.getClaims("ABC123");
    assertSame(defaultClaims, actualClaims);
    assertTrue(actualClaims.isEmpty());
    verify(jWTUtilService).getAllClaimsFromToken(Mockito.<String>any());
  }

  /** Method under test: {@link JWTUtilAdapter#generateToken(UserDto)} */
  @Test
  void testGenerateToken() {
    when(jWTUtilService.generateToken(Mockito.<UserDto>any())).thenReturn("ABC123");
    assertEquals("ABC123", jWTUtilAdapter.generateToken(new UserDto()));
    verify(jWTUtilService).generateToken(Mockito.<UserDto>any());
  }

  /** Method under test: {@link JWTUtilAdapter#getExpirationDateFromToken(String)} */
  @Test
  void testGetExpirationDateFromToken() {
    Date fromResult =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(jWTUtilService.getExpirationDateFromToken(Mockito.<String>any())).thenReturn(fromResult);
    assertSame(fromResult, jWTUtilAdapter.getExpirationDateFromToken("ABC123"));
    verify(jWTUtilService, atLeast(1)).getExpirationDateFromToken(Mockito.<String>any());
  }
}
