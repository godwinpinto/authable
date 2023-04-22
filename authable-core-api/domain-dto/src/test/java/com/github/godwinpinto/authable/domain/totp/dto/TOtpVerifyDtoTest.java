package com.github.godwinpinto.authable.domain.totp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TOtpVerifyDtoTest {
  /** Method under test: {@link TOtpVerifyDto#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse((new TOtpVerifyDto("Status Code", "Status Description")).canEqual("Other"));
  }

  /** Method under test: {@link TOtpVerifyDto#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", "Status Description");
    assertTrue(tOtpVerifyDto.canEqual(new TOtpVerifyDto("Status Code", "Status Description")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#TOtpVerifyDto()}
   *   <li>{@link TOtpVerifyDto#setStatusCode(String)}
   *   <li>{@link TOtpVerifyDto#setStatusDescription(String)}
   *   <li>{@link TOtpVerifyDto#toString()}
   *   <li>{@link TOtpVerifyDto#getStatusCode()}
   *   <li>{@link TOtpVerifyDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor() {
    TOtpVerifyDto actualTOtpVerifyDto = new TOtpVerifyDto();
    actualTOtpVerifyDto.setStatusCode("Status Code");
    actualTOtpVerifyDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpVerifyDto.toString();
    assertEquals("Status Code", actualTOtpVerifyDto.getStatusCode());
    assertEquals("Status Description", actualTOtpVerifyDto.getStatusDescription());
    assertEquals(
        "TOtpVerifyDto(statusCode=Status Code, statusDescription=Status Description)",
        actualToStringResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#TOtpVerifyDto(String, String)}
   *   <li>{@link TOtpVerifyDto#setStatusCode(String)}
   *   <li>{@link TOtpVerifyDto#setStatusDescription(String)}
   *   <li>{@link TOtpVerifyDto#toString()}
   *   <li>{@link TOtpVerifyDto#getStatusCode()}
   *   <li>{@link TOtpVerifyDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    TOtpVerifyDto actualTOtpVerifyDto = new TOtpVerifyDto("Status Code", "Status Description");
    actualTOtpVerifyDto.setStatusCode("Status Code");
    actualTOtpVerifyDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpVerifyDto.toString();
    assertEquals("Status Code", actualTOtpVerifyDto.getStatusCode());
    assertEquals("Status Description", actualTOtpVerifyDto.getStatusDescription());
    assertEquals(
        "TOtpVerifyDto(statusCode=Status Code, statusDescription=Status Description)",
        actualToStringResult);
  }

  /** Method under test: {@link TOtpVerifyDto#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new TOtpVerifyDto("Status Code", "Status Description"), null);
    assertNotEquals(
        new TOtpVerifyDto("Status Code", "Status Description"), "Different type to TOtpVerifyDto");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#equals(Object)}
   *   <li>{@link TOtpVerifyDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", "Status Description");
    assertEquals(tOtpVerifyDto, tOtpVerifyDto);
    int expectedHashCodeResult = tOtpVerifyDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpVerifyDto.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#equals(Object)}
   *   <li>{@link TOtpVerifyDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", "Status Description");
    TOtpVerifyDto tOtpVerifyDto2 = new TOtpVerifyDto("Status Code", "Status Description");

    assertEquals(tOtpVerifyDto, tOtpVerifyDto2);
    int expectedHashCodeResult = tOtpVerifyDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpVerifyDto2.hashCode());
  }

  /** Method under test: {@link TOtpVerifyDto#equals(Object)} */
  @Test
  void testEquals4() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Description", "Status Description");
    assertNotEquals(tOtpVerifyDto, new TOtpVerifyDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpVerifyDto#equals(Object)} */
  @Test
  void testEquals5() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto(null, "Status Description");
    assertNotEquals(tOtpVerifyDto, new TOtpVerifyDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpVerifyDto#equals(Object)} */
  @Test
  void testEquals6() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", "Status Code");
    assertNotEquals(tOtpVerifyDto, new TOtpVerifyDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpVerifyDto#equals(Object)} */
  @Test
  void testEquals7() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", null);
    assertNotEquals(tOtpVerifyDto, new TOtpVerifyDto("Status Code", "Status Description"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#equals(Object)}
   *   <li>{@link TOtpVerifyDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto(null, "Status Description");
    TOtpVerifyDto tOtpVerifyDto2 = new TOtpVerifyDto(null, "Status Description");

    assertEquals(tOtpVerifyDto, tOtpVerifyDto2);
    int expectedHashCodeResult = tOtpVerifyDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpVerifyDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpVerifyDto#equals(Object)}
   *   <li>{@link TOtpVerifyDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals9() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", null);
    TOtpVerifyDto tOtpVerifyDto2 = new TOtpVerifyDto("Status Code", null);

    assertEquals(tOtpVerifyDto, tOtpVerifyDto2);
    int expectedHashCodeResult = tOtpVerifyDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpVerifyDto2.hashCode());
  }

  @Test
  void testBuilder() {
    TOtpVerifyDto tOtpVerifyDto = new TOtpVerifyDto("Status Code", "DESCRIPTION");
    TOtpVerifyDto tOtpVerifyDto2 =
        TOtpVerifyDto.builder().statusCode("Status Code").statusDescription("DESCRIPTION").build();

    assertEquals(tOtpVerifyDto, tOtpVerifyDto2);
  }
}
