package com.github.godwinpinto.authable.domain.totp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TOtpGenerateQrDtoTest {
  /** Method under test: {@link TOtpGenerateQrDto#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse(
        (new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image")).canEqual("Other"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image");
    assertTrue(
        tOtpGenerateQrDto.canEqual(
            new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#TOtpGenerateQrDto()}
   *   <li>{@link TOtpGenerateQrDto#setQrImage(String)}
   *   <li>{@link TOtpGenerateQrDto#setStatusCode(String)}
   *   <li>{@link TOtpGenerateQrDto#setStatusDescription(String)}
   *   <li>{@link TOtpGenerateQrDto#toString()}
   *   <li>{@link TOtpGenerateQrDto#getQrImage()}
   *   <li>{@link TOtpGenerateQrDto#getStatusCode()}
   *   <li>{@link TOtpGenerateQrDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor() {
    TOtpGenerateQrDto actualTOtpGenerateQrDto = new TOtpGenerateQrDto();
    actualTOtpGenerateQrDto.setQrImage("Qr Image");
    actualTOtpGenerateQrDto.setStatusCode("Status Code");
    actualTOtpGenerateQrDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpGenerateQrDto.toString();
    assertEquals("Qr Image", actualTOtpGenerateQrDto.getQrImage());
    assertEquals("Status Code", actualTOtpGenerateQrDto.getStatusCode());
    assertEquals("Status Description", actualTOtpGenerateQrDto.getStatusDescription());
    assertEquals(
        "TOtpGenerateQrDto(statusCode=Status Code, statusDescription=Status Description, qrImage=Qr Image)",
        actualToStringResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#TOtpGenerateQrDto(String, String, String)}
   *   <li>{@link TOtpGenerateQrDto#setQrImage(String)}
   *   <li>{@link TOtpGenerateQrDto#setStatusCode(String)}
   *   <li>{@link TOtpGenerateQrDto#setStatusDescription(String)}
   *   <li>{@link TOtpGenerateQrDto#toString()}
   *   <li>{@link TOtpGenerateQrDto#getQrImage()}
   *   <li>{@link TOtpGenerateQrDto#getStatusCode()}
   *   <li>{@link TOtpGenerateQrDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    TOtpGenerateQrDto actualTOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image");
    actualTOtpGenerateQrDto.setQrImage("Qr Image");
    actualTOtpGenerateQrDto.setStatusCode("Status Code");
    actualTOtpGenerateQrDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpGenerateQrDto.toString();
    assertEquals("Qr Image", actualTOtpGenerateQrDto.getQrImage());
    assertEquals("Status Code", actualTOtpGenerateQrDto.getStatusCode());
    assertEquals("Status Description", actualTOtpGenerateQrDto.getStatusDescription());
    assertEquals(
        "TOtpGenerateQrDto(statusCode=Status Code, statusDescription=Status Description, qrImage=Qr Image)",
        actualToStringResult);
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"), null);
    assertNotEquals(
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"),
        "Different type to TOtpGenerateQrDto");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#equals(Object)}
   *   <li>{@link TOtpGenerateQrDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image");
    assertEquals(tOtpGenerateQrDto, tOtpGenerateQrDto);
    int expectedHashCodeResult = tOtpGenerateQrDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpGenerateQrDto.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#equals(Object)}
   *   <li>{@link TOtpGenerateQrDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image");
    TOtpGenerateQrDto tOtpGenerateQrDto2 =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image");

    assertEquals(tOtpGenerateQrDto, tOtpGenerateQrDto2);
    int expectedHashCodeResult = tOtpGenerateQrDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpGenerateQrDto2.hashCode());
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals4() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Description", "Status Description", "Qr Image");
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals5() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto(null, "Status Description", "Qr Image");
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals6() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Code", "Qr Image");
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals7() {
    TOtpGenerateQrDto tOtpGenerateQrDto = new TOtpGenerateQrDto("Status Code", null, "Qr Image");
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals8() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", "Status Code");
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /** Method under test: {@link TOtpGenerateQrDto#equals(Object)} */
  @Test
  void testEquals9() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", null);
    assertNotEquals(
        tOtpGenerateQrDto, new TOtpGenerateQrDto("Status Code", "Status Description", "Qr Image"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#equals(Object)}
   *   <li>{@link TOtpGenerateQrDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals10() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto(null, "Status Description", "Qr Image");
    TOtpGenerateQrDto tOtpGenerateQrDto2 =
        new TOtpGenerateQrDto(null, "Status Description", "Qr Image");

    assertEquals(tOtpGenerateQrDto, tOtpGenerateQrDto2);
    int expectedHashCodeResult = tOtpGenerateQrDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpGenerateQrDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#equals(Object)}
   *   <li>{@link TOtpGenerateQrDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals11() {
    TOtpGenerateQrDto tOtpGenerateQrDto = new TOtpGenerateQrDto("Status Code", null, "Qr Image");
    TOtpGenerateQrDto tOtpGenerateQrDto2 = new TOtpGenerateQrDto("Status Code", null, "Qr Image");

    assertEquals(tOtpGenerateQrDto, tOtpGenerateQrDto2);
    int expectedHashCodeResult = tOtpGenerateQrDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpGenerateQrDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpGenerateQrDto#equals(Object)}
   *   <li>{@link TOtpGenerateQrDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals12() {
    TOtpGenerateQrDto tOtpGenerateQrDto =
        new TOtpGenerateQrDto("Status Code", "Status Description", null);
    TOtpGenerateQrDto tOtpGenerateQrDto2 =
        new TOtpGenerateQrDto("Status Code", "Status Description", null);

    assertEquals(tOtpGenerateQrDto, tOtpGenerateQrDto2);
    int expectedHashCodeResult = tOtpGenerateQrDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpGenerateQrDto2.hashCode());
  }

  @Test
  void testBuilder() {
    TOtpGenerateQrDto tOtpCreateNewDto =
        new TOtpGenerateQrDto("Status Code", "DESCRIPTION", "IMAGE");
    TOtpGenerateQrDto tOtpCreateNewDto2 =
        TOtpGenerateQrDto.builder()
            .statusCode("Status Code")
            .statusDescription("DESCRIPTION")
            .qrImage("IMAGE")
            .build();

    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
  }
}
