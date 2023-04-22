package com.github.godwinpinto.authable.domain.totp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TOtpUnSubscribeUserDtoTest {
  /** Method under test: {@link TOtpUnSubscribeUserDto#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse(
        (new TOtpUnSubscribeUserDto("Status Code", "Status Description")).canEqual("Other"));
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "Status Description");
    assertTrue(
        tOtpUnSubscribeUserDto.canEqual(
            new TOtpUnSubscribeUserDto("Status Code", "Status Description")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#TOtpUnSubscribeUserDto()}
   *   <li>{@link TOtpUnSubscribeUserDto#setStatusCode(String)}
   *   <li>{@link TOtpUnSubscribeUserDto#setStatusDescription(String)}
   *   <li>{@link TOtpUnSubscribeUserDto#toString()}
   *   <li>{@link TOtpUnSubscribeUserDto#getStatusCode()}
   *   <li>{@link TOtpUnSubscribeUserDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor() {
    TOtpUnSubscribeUserDto actualTOtpUnSubscribeUserDto = new TOtpUnSubscribeUserDto();
    actualTOtpUnSubscribeUserDto.setStatusCode("Status Code");
    actualTOtpUnSubscribeUserDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpUnSubscribeUserDto.toString();
    assertEquals("Status Code", actualTOtpUnSubscribeUserDto.getStatusCode());
    assertEquals("Status Description", actualTOtpUnSubscribeUserDto.getStatusDescription());
    assertEquals(
        "TOtpUnSubscribeUserDto(statusCode=Status Code, statusDescription=Status Description)",
        actualToStringResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#TOtpUnSubscribeUserDto(String, String)}
   *   <li>{@link TOtpUnSubscribeUserDto#setStatusCode(String)}
   *   <li>{@link TOtpUnSubscribeUserDto#setStatusDescription(String)}
   *   <li>{@link TOtpUnSubscribeUserDto#toString()}
   *   <li>{@link TOtpUnSubscribeUserDto#getStatusCode()}
   *   <li>{@link TOtpUnSubscribeUserDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    TOtpUnSubscribeUserDto actualTOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "Status Description");
    actualTOtpUnSubscribeUserDto.setStatusCode("Status Code");
    actualTOtpUnSubscribeUserDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpUnSubscribeUserDto.toString();
    assertEquals("Status Code", actualTOtpUnSubscribeUserDto.getStatusCode());
    assertEquals("Status Description", actualTOtpUnSubscribeUserDto.getStatusDescription());
    assertEquals(
        "TOtpUnSubscribeUserDto(statusCode=Status Code, statusDescription=Status Description)",
        actualToStringResult);
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new TOtpUnSubscribeUserDto("Status Code", "Status Description"), null);
    assertNotEquals(
        new TOtpUnSubscribeUserDto("Status Code", "Status Description"),
        "Different type to TOtpUnSubscribeUserDto");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#equals(Object)}
   *   <li>{@link TOtpUnSubscribeUserDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "Status Description");
    assertEquals(tOtpUnSubscribeUserDto, tOtpUnSubscribeUserDto);
    int expectedHashCodeResult = tOtpUnSubscribeUserDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpUnSubscribeUserDto.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#equals(Object)}
   *   <li>{@link TOtpUnSubscribeUserDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "Status Description");
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto2 =
        new TOtpUnSubscribeUserDto("Status Code", "Status Description");

    assertEquals(tOtpUnSubscribeUserDto, tOtpUnSubscribeUserDto2);
    int expectedHashCodeResult = tOtpUnSubscribeUserDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpUnSubscribeUserDto2.hashCode());
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#equals(Object)} */
  @Test
  void testEquals4() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Description", "Status Description");
    assertNotEquals(
        tOtpUnSubscribeUserDto, new TOtpUnSubscribeUserDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#equals(Object)} */
  @Test
  void testEquals5() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto(null, "Status Description");
    assertNotEquals(
        tOtpUnSubscribeUserDto, new TOtpUnSubscribeUserDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#equals(Object)} */
  @Test
  void testEquals6() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "Status Code");
    assertNotEquals(
        tOtpUnSubscribeUserDto, new TOtpUnSubscribeUserDto("Status Code", "Status Description"));
  }

  /** Method under test: {@link TOtpUnSubscribeUserDto#equals(Object)} */
  @Test
  void testEquals7() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto = new TOtpUnSubscribeUserDto("Status Code", null);
    assertNotEquals(
        tOtpUnSubscribeUserDto, new TOtpUnSubscribeUserDto("Status Code", "Status Description"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#equals(Object)}
   *   <li>{@link TOtpUnSubscribeUserDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals8() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto(null, "Status Description");
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto2 =
        new TOtpUnSubscribeUserDto(null, "Status Description");

    assertEquals(tOtpUnSubscribeUserDto, tOtpUnSubscribeUserDto2);
    int expectedHashCodeResult = tOtpUnSubscribeUserDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpUnSubscribeUserDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpUnSubscribeUserDto#equals(Object)}
   *   <li>{@link TOtpUnSubscribeUserDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals9() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto = new TOtpUnSubscribeUserDto("Status Code", null);
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto2 =
        new TOtpUnSubscribeUserDto("Status Code", null);

    assertEquals(tOtpUnSubscribeUserDto, tOtpUnSubscribeUserDto2);
    int expectedHashCodeResult = tOtpUnSubscribeUserDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpUnSubscribeUserDto2.hashCode());
  }

  @Test
  void testBuilder() {
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto =
        new TOtpUnSubscribeUserDto("Status Code", "DESCRIPTION");
    TOtpUnSubscribeUserDto tOtpUnSubscribeUserDto2 =
        TOtpUnSubscribeUserDto.builder()
            .statusCode("Status Code")
            .statusDescription("DESCRIPTION")
            .build();

    assertEquals(tOtpUnSubscribeUserDto, tOtpUnSubscribeUserDto2);
  }
}
