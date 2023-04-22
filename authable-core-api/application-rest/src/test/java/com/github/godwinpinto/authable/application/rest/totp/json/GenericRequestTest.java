package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GenericRequestTest {
  /** Method under test: {@link GenericRequest#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse((new GenericRequest("42")).canEqual("Other"));
  }

  /** Method under test: {@link GenericRequest#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    GenericRequest genericRequest = new GenericRequest("42");
    assertTrue(genericRequest.canEqual(new GenericRequest("42")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link GenericRequest#GenericRequest()}
   *   <li>{@link GenericRequest#setUserId(String)}
   *   <li>{@link GenericRequest#toString()}
   *   <li>{@link GenericRequest#getUserId()}
   * </ul>
   */
  @Test
  void testConstructor() {
    GenericRequest actualGenericRequest = new GenericRequest();
    actualGenericRequest.setUserId("42");
    String actualToStringResult = actualGenericRequest.toString();
    assertEquals("42", actualGenericRequest.getUserId());
    assertEquals("GenericRequest(userId=42)", actualToStringResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link GenericRequest#GenericRequest(String)}
   *   <li>{@link GenericRequest#setUserId(String)}
   *   <li>{@link GenericRequest#toString()}
   *   <li>{@link GenericRequest#getUserId()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    GenericRequest actualGenericRequest = new GenericRequest("42");
    actualGenericRequest.setUserId("42");
    String actualToStringResult = actualGenericRequest.toString();
    assertEquals("42", actualGenericRequest.getUserId());
    assertEquals("GenericRequest(userId=42)", actualToStringResult);
  }

  /** Method under test: {@link GenericRequest#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new GenericRequest("42"), null);
    assertNotEquals(new GenericRequest("42"), "Different type to GenericRequest");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link GenericRequest#equals(Object)}
   *   <li>{@link GenericRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    GenericRequest genericRequest = new GenericRequest("42");
    assertEquals(genericRequest, genericRequest);
    int expectedHashCodeResult = genericRequest.hashCode();
    assertEquals(expectedHashCodeResult, genericRequest.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link GenericRequest#equals(Object)}
   *   <li>{@link GenericRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    GenericRequest genericRequest = new GenericRequest("42");
    GenericRequest genericRequest2 = new GenericRequest("42");
    assertEquals(genericRequest, genericRequest2);
    int expectedHashCodeResult = genericRequest.hashCode();
    assertEquals(expectedHashCodeResult, genericRequest2.hashCode());
  }

  /** Method under test: {@link GenericRequest#equals(Object)} */
  @Test
  void testEquals4() {
    GenericRequest genericRequest = new GenericRequest("User Id");
    assertNotEquals(genericRequest, new GenericRequest("42"));
  }

  /** Method under test: {@link GenericRequest#equals(Object)} */
  @Test
  void testEquals5() {
    GenericRequest genericRequest = new GenericRequest(null);
    assertNotEquals(genericRequest, new GenericRequest("42"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link GenericRequest#equals(Object)}
   *   <li>{@link GenericRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEquals6() {
    GenericRequest genericRequest = new GenericRequest(null);
    GenericRequest genericRequest2 = new GenericRequest(null);
    assertEquals(genericRequest, genericRequest2);
    int expectedHashCodeResult = genericRequest.hashCode();
    assertEquals(expectedHashCodeResult, genericRequest2.hashCode());
  }
}
