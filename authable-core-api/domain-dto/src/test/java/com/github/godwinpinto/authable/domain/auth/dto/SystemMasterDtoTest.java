package com.github.godwinpinto.authable.domain.auth.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class SystemMasterDtoTest {
  /**
   * Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemMasterDto}
   *   <li>{@link SystemMasterDto#setCreationDateTime(LocalDateTime)}
   *   <li>{@link SystemMasterDto#setCreationId(String)}
   *   <li>{@link SystemMasterDto#setModificationDateTime(LocalDateTime)}
   *   <li>{@link SystemMasterDto#setModificationId(String)}
   *   <li>{@link SystemMasterDto#setStatus(String)}
   *   <li>{@link SystemMasterDto#setSystemDescription(String)}
   *   <li>{@link SystemMasterDto#setSystemId(String)}
   *   <li>{@link SystemMasterDto#setSystemName(String)}
   *   <li>{@link SystemMasterDto#toString()}
   *   <li>{@link SystemMasterDto#getCreationDateTime()}
   *   <li>{@link SystemMasterDto#getCreationId()}
   *   <li>{@link SystemMasterDto#getModificationDateTime()}
   *   <li>{@link SystemMasterDto#getModificationId()}
   *   <li>{@link SystemMasterDto#getStatus()}
   *   <li>{@link SystemMasterDto#getSystemDescription()}
   *   <li>{@link SystemMasterDto#getSystemId()}
   *   <li>{@link SystemMasterDto#getSystemName()}
   * </ul>
   */
  @Test
  void testConstructor() {
    SystemMasterDto actualSystemMasterDto = new SystemMasterDto();
    LocalDateTime creationDateTime = LocalDate.of(1970, 1, 1).atStartOfDay();
    actualSystemMasterDto.setCreationDateTime(creationDateTime);
    actualSystemMasterDto.setCreationId("42");
    LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1).atStartOfDay();
    actualSystemMasterDto.setModificationDateTime(modificationDateTime);
    actualSystemMasterDto.setModificationId("42");
    actualSystemMasterDto.setStatus("Status");
    actualSystemMasterDto.setSystemDescription("System Description");
    actualSystemMasterDto.setSystemId("42");
    actualSystemMasterDto.setSystemName("System Name");
    String actualToStringResult = actualSystemMasterDto.toString();
    assertSame(creationDateTime, actualSystemMasterDto.getCreationDateTime());
    assertEquals("42", actualSystemMasterDto.getCreationId());
    assertSame(modificationDateTime, actualSystemMasterDto.getModificationDateTime());
    assertEquals("42", actualSystemMasterDto.getModificationId());
    assertEquals("Status", actualSystemMasterDto.getStatus());
    assertEquals("System Description", actualSystemMasterDto.getSystemDescription());
    assertEquals("42", actualSystemMasterDto.getSystemId());
    assertEquals("System Name", actualSystemMasterDto.getSystemName());
    assertEquals(
        "SystemMasterDto(systemId=42, systemName=System Name, systemDescription=System Description, status=Status,"
            + " modificationId=42, modificationDateTime=1970-01-01T00:00, creationId=42, creationDateTime=1970-01"
            + "-01T00:00)",
        actualToStringResult);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");
    assertNotEquals(systemMasterDto, null);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals2() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");
    assertNotEquals(systemMasterDto, "Different type to SystemMasterDto");
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link SystemMasterDto#equals(Object)}
   *   <li>{@link SystemMasterDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals3() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");
    assertEquals(systemMasterDto, systemMasterDto);
    int expectedHashCodeResult = systemMasterDto.hashCode();
    assertEquals(expectedHashCodeResult, systemMasterDto.hashCode());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link SystemMasterDto#equals(Object)}
   *   <li>{@link SystemMasterDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals4() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertEquals(systemMasterDto, systemMasterDto2);
    int expectedHashCodeResult = systemMasterDto.hashCode();
    assertEquals(expectedHashCodeResult, systemMasterDto2.hashCode());
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals5() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.now().atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals6() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("System Name");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals7() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId(null);
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals8() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.now().atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals9() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("System Name");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals10() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId(null);
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals11() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("42");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals12() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus(null);
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals13() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("42");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals14() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription(null);
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals15() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("System Name");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals16() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId(null);
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals17() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("42");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /** Method under test: {@link SystemMasterDto#equals(Object)} */
  @Test
  void testEquals18() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId("42");
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName(null);

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId("42");
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertNotEquals(systemMasterDto, systemMasterDto2);
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link SystemMasterDto#equals(Object)}
   *   <li>{@link SystemMasterDto#hashCode()}
   * </ul>
   */
  @Test
  void testEquals19() {
    SystemMasterDto systemMasterDto = new SystemMasterDto();
    systemMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setCreationId(null);
    systemMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto.setModificationId("42");
    systemMasterDto.setStatus("Status");
    systemMasterDto.setSystemDescription("System Description");
    systemMasterDto.setSystemId("42");
    systemMasterDto.setSystemName("System Name");

    SystemMasterDto systemMasterDto2 = new SystemMasterDto();
    systemMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setCreationId(null);
    systemMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    systemMasterDto2.setModificationId("42");
    systemMasterDto2.setStatus("Status");
    systemMasterDto2.setSystemDescription("System Description");
    systemMasterDto2.setSystemId("42");
    systemMasterDto2.setSystemName("System Name");
    assertEquals(systemMasterDto, systemMasterDto2);
    int expectedHashCodeResult = systemMasterDto.hashCode();
    assertEquals(expectedHashCodeResult, systemMasterDto2.hashCode());
  }
}
