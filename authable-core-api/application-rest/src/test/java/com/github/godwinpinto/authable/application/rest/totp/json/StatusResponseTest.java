package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatusResponseTest {
  /** Method under test: {@link StatusResponse#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse((new StatusResponse("Status Code", "Status Description")).canEqual("Other"));
  }

  /** Method under test: {@link StatusResponse#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description");
    assertTrue(statusResponse.canEqual(new StatusResponse("Status Code", "Status Description")));
  }

  /** Method under test: {@link StatusResponse#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new StatusResponse("Status Code", "Status Description"), null);
    assertNotEquals(
        new StatusResponse("Status Code", "Status Description"),
        "Different type to StatusResponse");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link StatusResponse#equals(Object)}
   *   <li>{@link StatusResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description");
    assertEquals(statusResponse, statusResponse);
    int expectedHashCodeResult = statusResponse.hashCode();
    assertEquals(expectedHashCodeResult, statusResponse.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link StatusResponse#equals(Object)}
   *   <li>{@link StatusResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description");
    StatusResponse statusResponse2 = new StatusResponse("Status Code", "Status Description");

    assertEquals(statusResponse, statusResponse2);
    int expectedHashCodeResult = statusResponse.hashCode();
    assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
  }

  /** Method under test: {@link StatusResponse#equals(Object)} */
  @Test
  void testEquals4() {
    StatusResponse statusResponse = new StatusResponse("Status Description", "Status Description");
    assertNotEquals(statusResponse, new StatusResponse("Status Code", "Status Description"));
  }

  /** Method under test: {@link StatusResponse#equals(Object)} */
  @Test
  void testEquals5() {
    StatusResponse statusResponse = new StatusResponse(null, "Status Description");
    assertNotEquals(statusResponse, new StatusResponse("Status Code", "Status Description"));
  }

  /** Method under test: {@link StatusResponse#equals(Object)} */
  @Test
  void testEquals6() {
    StatusResponse statusResponse = new StatusResponse("Status Code", "Status Code");
    assertNotEquals(statusResponse, new StatusResponse("Status Code", "Status Description"));
  }

  /** Method under test: {@link StatusResponse#equals(Object)} */
  @Test
  void testEquals7() {
    StatusResponse statusResponse = new StatusResponse("Status Code", null);
    assertNotEquals(statusResponse, new StatusResponse("Status Code", "Status Description"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link StatusResponse#equals(Object)}
   *   <li>{@link StatusResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals10() {
    StatusResponse statusResponse = new StatusResponse(null, "Status Description");
    StatusResponse statusResponse2 = new StatusResponse(null, "Status Description");

    assertEquals(statusResponse, statusResponse2);
    int expectedHashCodeResult = statusResponse.hashCode();
    assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link StatusResponse#equals(Object)}
   *   <li>{@link StatusResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals11() {
    StatusResponse statusResponse = new StatusResponse("Status Code", null);
    StatusResponse statusResponse2 = new StatusResponse("Status Code", null);

    assertEquals(statusResponse, statusResponse2);
    int expectedHashCodeResult = statusResponse.hashCode();
    assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link StatusResponse#equals(Object)}
   *   <li>{@link StatusResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEquals12() {
    StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description");
    StatusResponse statusResponse2 = new StatusResponse("Status Code", "Status Description");

    assertEquals(statusResponse, statusResponse2);
    int expectedHashCodeResult = statusResponse.hashCode();
    assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
  }
}
