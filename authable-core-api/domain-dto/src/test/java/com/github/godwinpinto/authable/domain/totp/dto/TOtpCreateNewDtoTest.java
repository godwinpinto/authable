package com.github.godwinpinto.authable.domain.totp.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TOtpCreateNewDtoTest {
  /** Method under test: {@link TOtpCreateNewDto#canEqual(Object)} */
  @Test
  void testCanEqual() {
    assertFalse(
        (new TOtpCreateNewDto(
                "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"))
            .canEqual("Other"));
  }

  /** Method under test: {@link TOtpCreateNewDto#canEqual(Object)} */
  @Test
  void testCanEqual2() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertTrue(
        tOtpCreateNewDto.canEqual(
            new TOtpCreateNewDto(
                "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#TOtpCreateNewDto()}
   *   <li>{@link TOtpCreateNewDto#setSecretKey(String)}
   *   <li>{@link TOtpCreateNewDto#setStatusCode(String)}
   *   <li>{@link TOtpCreateNewDto#setStatusDescription(String)}
   *   <li>{@link TOtpCreateNewDto#toString()}
   *   <li>{@link TOtpCreateNewDto#getSecretKey()}
   *   <li>{@link TOtpCreateNewDto#getStatusCode()}
   *   <li>{@link TOtpCreateNewDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor() {
    TOtpCreateNewDto actualTOtpCreateNewDto = new TOtpCreateNewDto();
    actualTOtpCreateNewDto.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    actualTOtpCreateNewDto.setStatusCode("Status Code");
    actualTOtpCreateNewDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpCreateNewDto.toString();
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualTOtpCreateNewDto.getSecretKey());
    assertEquals("Status Code", actualTOtpCreateNewDto.getStatusCode());
    assertEquals("Status Description", actualTOtpCreateNewDto.getStatusDescription());
    assertEquals(
        "TOtpCreateNewDto(statusCode=Status Code, statusDescription=Status Description, secretKey=EXAMPLEKEYw"
            + "jalrXUtnFEMI/K7MDENG/bPxRfiCY)",
        actualToStringResult);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#TOtpCreateNewDto(String, String, String)}
   *   <li>{@link TOtpCreateNewDto#setSecretKey(String)}
   *   <li>{@link TOtpCreateNewDto#setStatusCode(String)}
   *   <li>{@link TOtpCreateNewDto#setStatusDescription(String)}
   *   <li>{@link TOtpCreateNewDto#toString()}
   *   <li>{@link TOtpCreateNewDto#getSecretKey()}
   *   <li>{@link TOtpCreateNewDto#getStatusCode()}
   *   <li>{@link TOtpCreateNewDto#getStatusDescription()}
   * </ul>
   */
  @Test
  void testConstructor2() {
    TOtpCreateNewDto actualTOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    actualTOtpCreateNewDto.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    actualTOtpCreateNewDto.setStatusCode("Status Code");
    actualTOtpCreateNewDto.setStatusDescription("Status Description");
    String actualToStringResult = actualTOtpCreateNewDto.toString();
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualTOtpCreateNewDto.getSecretKey());
    assertEquals("Status Code", actualTOtpCreateNewDto.getStatusCode());
    assertEquals("Status Description", actualTOtpCreateNewDto.getStatusDescription());
    assertEquals(
        "TOtpCreateNewDto(statusCode=Status Code, statusDescription=Status Description, secretKey=EXAMPLEKEYw"
            + "jalrXUtnFEMI/K7MDENG/bPxRfiCY)",
        actualToStringResult);
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals() {
    assertNotEquals(
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
        null);
    assertNotEquals(
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
        "Different type to TOtpCreateNewDto");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#equals(Object)}
   *   <li>{@link TOtpCreateNewDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals2() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto);
    int expectedHashCodeResult = tOtpCreateNewDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpCreateNewDto.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#equals(Object)}
   *   <li>{@link TOtpCreateNewDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    TOtpCreateNewDto tOtpCreateNewDto2 =
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
    int expectedHashCodeResult = tOtpCreateNewDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpCreateNewDto2.hashCode());
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals4() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Description", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals5() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            null, "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals6() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            "Status Code", "Status Code", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals7() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals8() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", "Status Description", "Status Code");
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /** Method under test: {@link TOtpCreateNewDto#equals(Object)} */
  @Test
  void testEquals9() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", "Status Description", null);
    assertNotEquals(
        tOtpCreateNewDto,
        new TOtpCreateNewDto(
            "Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#equals(Object)}
   *   <li>{@link TOtpCreateNewDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals10() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto(
            null, "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    TOtpCreateNewDto tOtpCreateNewDto2 =
        new TOtpCreateNewDto(
            null, "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
    int expectedHashCodeResult = tOtpCreateNewDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpCreateNewDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#equals(Object)}
   *   <li>{@link TOtpCreateNewDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals11() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    TOtpCreateNewDto tOtpCreateNewDto2 =
        new TOtpCreateNewDto("Status Code", null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
    int expectedHashCodeResult = tOtpCreateNewDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpCreateNewDto2.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link TOtpCreateNewDto#equals(Object)}
   *   <li>{@link TOtpCreateNewDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals12() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", "Status Description", null);
    TOtpCreateNewDto tOtpCreateNewDto2 =
        new TOtpCreateNewDto("Status Code", "Status Description", null);

    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
    int expectedHashCodeResult = tOtpCreateNewDto.hashCode();
    assertEquals(expectedHashCodeResult, tOtpCreateNewDto2.hashCode());
  }

  @Test
  void testBuilder() {
    TOtpCreateNewDto tOtpCreateNewDto =
        new TOtpCreateNewDto("Status Code", null, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    TOtpCreateNewDto tOtpCreateNewDto2 =
        TOtpCreateNewDto.builder()
            .statusCode("Status Code")
            .secretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")
            .build();
    assertEquals(tOtpCreateNewDto, tOtpCreateNewDto2);
  }
}
