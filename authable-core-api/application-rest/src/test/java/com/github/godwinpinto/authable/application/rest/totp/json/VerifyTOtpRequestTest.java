package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerifyTOtpRequestTest {
  /** Method under test: {@link VerifyTOtpRequest#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse((new VerifyTOtpRequest("42", "Otp")).canEqual("Other"));
  }

  /** Method under test: {@link VerifyTOtpRequest#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", "Otp");
    assertTrue(verifyTOtpRequest.canEqual(new VerifyTOtpRequest("42", "Otp")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link VerifyTOtpRequest#VerifyTOtpRequest(String, String)}
   *   <li>{@link VerifyTOtpRequest#setOtp(String)}
   *   <li>{@link VerifyTOtpRequest#setUserId(String)}
   *   <li>{@link VerifyTOtpRequest#toString()}
   *   <li>{@link VerifyTOtpRequest#getOtp()}
   *   <li>{@link VerifyTOtpRequest#getUserId()}
   * </ul>
   */
  @Test
  void testConstructor() {
    VerifyTOtpRequest actualVerifyTOtpRequest = new VerifyTOtpRequest("42", "Otp");
    actualVerifyTOtpRequest.setOtp("Otp");
    actualVerifyTOtpRequest.setUserId("42");
    String actualToStringResult = actualVerifyTOtpRequest.toString();
    assertEquals("Otp", actualVerifyTOtpRequest.getOtp());
    assertEquals("42", actualVerifyTOtpRequest.getUserId());
    assertEquals("VerifyTOtpRequest(userId=42, otp=Otp)", actualToStringResult);
  }

  /** Method under test: {@link VerifyTOtpRequest#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new VerifyTOtpRequest("42", "Otp"), null);
    assertNotEquals(new VerifyTOtpRequest("42", "Otp"), "Different type to VerifyTOtpRequest");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link VerifyTOtpRequest#equals(Object)}
   *   <li>{@link VerifyTOtpRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", "Otp");
    assertEquals(verifyTOtpRequest, verifyTOtpRequest);
    int expectedHashCodeResult = verifyTOtpRequest.hashCode();
    assertEquals(expectedHashCodeResult, verifyTOtpRequest.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link VerifyTOtpRequest#equals(Object)}
   *   <li>{@link VerifyTOtpRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", "Otp");
    VerifyTOtpRequest verifyTOtpRequest2 = new VerifyTOtpRequest("42", "Otp");

    assertEquals(verifyTOtpRequest, verifyTOtpRequest2);
    int expectedHashCodeResult = verifyTOtpRequest.hashCode();
    assertEquals(expectedHashCodeResult, verifyTOtpRequest2.hashCode());
  }

  /** Method under test: {@link VerifyTOtpRequest#equals(Object)} */
  @Test
  void testEquals4() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("Otp", "Otp");
    assertNotEquals(verifyTOtpRequest, new VerifyTOtpRequest("42", "Otp"));
  }

  /** Method under test: {@link VerifyTOtpRequest#equals(Object)} */
  @Test
  void testEquals5() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest(null, "Otp");
    assertNotEquals(verifyTOtpRequest, new VerifyTOtpRequest("42", "Otp"));
  }

  /** Method under test: {@link VerifyTOtpRequest#equals(Object)} */
  @Test
  void testEquals6() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", "42");
    assertNotEquals(verifyTOtpRequest, new VerifyTOtpRequest("42", "Otp"));
  }

  /** Method under test: {@link VerifyTOtpRequest#equals(Object)} */
  @Test
  void testEquals7() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", null);
    assertNotEquals(verifyTOtpRequest, new VerifyTOtpRequest("42", "Otp"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link VerifyTOtpRequest#equals(Object)}
   *   <li>{@link VerifyTOtpRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest(null, "Otp");
    VerifyTOtpRequest verifyTOtpRequest2 = new VerifyTOtpRequest(null, "Otp");

    assertEquals(verifyTOtpRequest, verifyTOtpRequest2);
    int expectedHashCodeResult = verifyTOtpRequest.hashCode();
    assertEquals(expectedHashCodeResult, verifyTOtpRequest2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link VerifyTOtpRequest#equals(Object)}
   *   <li>{@link VerifyTOtpRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals9() {
    VerifyTOtpRequest verifyTOtpRequest = new VerifyTOtpRequest("42", null);
    VerifyTOtpRequest verifyTOtpRequest2 = new VerifyTOtpRequest("42", null);

    assertEquals(verifyTOtpRequest, verifyTOtpRequest2);
    int expectedHashCodeResult = verifyTOtpRequest.hashCode();
    assertEquals(expectedHashCodeResult, verifyTOtpRequest2.hashCode());
  }
}
