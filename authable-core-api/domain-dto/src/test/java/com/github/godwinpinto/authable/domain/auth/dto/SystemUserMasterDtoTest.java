package com.github.godwinpinto.authable.domain.auth.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class SystemUserMasterDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SystemUserMasterDto}
     *   <li>{@link SystemUserMasterDto#setAccessId(String)}
     *   <li>{@link SystemUserMasterDto#setCreationDateTime(LocalDateTime)}
     *   <li>{@link SystemUserMasterDto#setCreationId(String)}
     *   <li>{@link SystemUserMasterDto#setInvalidAttemptDateTime(LocalDateTime)}
     *   <li>{@link SystemUserMasterDto#setLastLoginDateTime(LocalDateTime)}
     *   <li>{@link SystemUserMasterDto#setLockedDateTime(LocalDateTime)}
     *   <li>{@link SystemUserMasterDto#setModificationDateTime(LocalDateTime)}
     *   <li>{@link SystemUserMasterDto#setModificationId(String)}
     *   <li>{@link SystemUserMasterDto#setNoOfAttempts(short)}
     *   <li>{@link SystemUserMasterDto#setStatus(String)}
     *   <li>{@link SystemUserMasterDto#setSystemId(String)}
     *   <li>{@link SystemUserMasterDto#setUserFullName(String)}
     *   <li>{@link SystemUserMasterDto#setUserIpRange(String)}
     *   <li>{@link SystemUserMasterDto#setUserName(String)}
     *   <li>{@link SystemUserMasterDto#setUserSecret(String)}
     *   <li>{@link SystemUserMasterDto#toString()}
     *   <li>{@link SystemUserMasterDto#getAccessId()}
     *   <li>{@link SystemUserMasterDto#getCreationDateTime()}
     *   <li>{@link SystemUserMasterDto#getCreationId()}
     *   <li>{@link SystemUserMasterDto#getInvalidAttemptDateTime()}
     *   <li>{@link SystemUserMasterDto#getLastLoginDateTime()}
     *   <li>{@link SystemUserMasterDto#getLockedDateTime()}
     *   <li>{@link SystemUserMasterDto#getModificationDateTime()}
     *   <li>{@link SystemUserMasterDto#getModificationId()}
     *   <li>{@link SystemUserMasterDto#getNoOfAttempts()}
     *   <li>{@link SystemUserMasterDto#getStatus()}
     *   <li>{@link SystemUserMasterDto#getSystemId()}
     *   <li>{@link SystemUserMasterDto#getUserFullName()}
     *   <li>{@link SystemUserMasterDto#getUserIpRange()}
     *   <li>{@link SystemUserMasterDto#getUserName()}
     *   <li>{@link SystemUserMasterDto#getUserSecret()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SystemUserMasterDto actualSystemUserMasterDto = new SystemUserMasterDto();
        actualSystemUserMasterDto.setAccessId("42");
        LocalDateTime creationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualSystemUserMasterDto.setCreationDateTime(creationDateTime);
        actualSystemUserMasterDto.setCreationId("42");
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualSystemUserMasterDto.setInvalidAttemptDateTime(invalidAttemptDateTime);
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualSystemUserMasterDto.setLastLoginDateTime(lastLoginDateTime);
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualSystemUserMasterDto.setLockedDateTime(lockedDateTime);
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualSystemUserMasterDto.setModificationDateTime(modificationDateTime);
        actualSystemUserMasterDto.setModificationId("42");
        actualSystemUserMasterDto.setNoOfAttempts((short) 1);
        actualSystemUserMasterDto.setStatus("Status");
        actualSystemUserMasterDto.setSystemId("42");
        actualSystemUserMasterDto.setUserFullName("Dr Jane Doe");
        actualSystemUserMasterDto.setUserIpRange("User Ip Range");
        actualSystemUserMasterDto.setUserName("janedoe");
        actualSystemUserMasterDto.setUserSecret("User Secret");
        String actualToStringResult = actualSystemUserMasterDto.toString();
        assertEquals("42", actualSystemUserMasterDto.getAccessId());
        assertSame(creationDateTime, actualSystemUserMasterDto.getCreationDateTime());
        assertEquals("42", actualSystemUserMasterDto.getCreationId());
        assertSame(invalidAttemptDateTime, actualSystemUserMasterDto.getInvalidAttemptDateTime());
        assertSame(lastLoginDateTime, actualSystemUserMasterDto.getLastLoginDateTime());
        assertSame(lockedDateTime, actualSystemUserMasterDto.getLockedDateTime());
        assertSame(modificationDateTime, actualSystemUserMasterDto.getModificationDateTime());
        assertEquals("42", actualSystemUserMasterDto.getModificationId());
        assertEquals((short) 1, actualSystemUserMasterDto.getNoOfAttempts());
        assertEquals("Status", actualSystemUserMasterDto.getStatus());
        assertEquals("42", actualSystemUserMasterDto.getSystemId());
        assertEquals("Dr Jane Doe", actualSystemUserMasterDto.getUserFullName());
        assertEquals("User Ip Range", actualSystemUserMasterDto.getUserIpRange());
        assertEquals("janedoe", actualSystemUserMasterDto.getUserName());
        assertEquals("User Secret", actualSystemUserMasterDto.getUserSecret());
        assertEquals(
                "SystemUserMasterDto(accessId=42, systemId=42, userName=janedoe, userSecret=User Secret, userFullName=Dr"
                        + " Jane Doe, userIpRange=User Ip Range, noOfAttempts=1, status=Status, lastLoginDateTime=1970-01-01T00:00,"
                        + " invalidAttemptDateTime=1970-01-01T00:00, lockedDateTime=1970-01-01T00:00, modificationId=42,"
                        + " modificationDateTime=1970-01-01T00:00, creationId=42, creationDateTime=1970-01-01T00:00)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, null);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals2() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, "Different type to SystemUserMasterDto");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SystemUserMasterDto#equals(Object)}
     *   <li>{@link SystemUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");
        assertEquals(systemUserMasterDto, systemUserMasterDto);
        int expectedHashCodeResult = systemUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, systemUserMasterDto.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SystemUserMasterDto#equals(Object)}
     *   <li>{@link SystemUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertEquals(systemUserMasterDto, systemUserMasterDto2);
        int expectedHashCodeResult = systemUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, systemUserMasterDto2.hashCode());
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals5() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("janedoe");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals6() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId(null);
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals7() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.now()
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals8() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("janedoe");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals9() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId(null);
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals10() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.now()
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals11() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.now()
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals12() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.now()
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals13() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.now()
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals14() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("janedoe");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals15() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId(null);
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals16() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 3);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals17() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("42");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals18() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus(null);
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals19() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("janedoe");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals20() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId(null);
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals21() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Mr John Smith");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals22() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName(null);
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals23() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("42");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals24() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange(null);
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals25() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("42");
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals26() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName(null);
        systemUserMasterDto.setUserSecret("User Secret");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals27() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret("42");

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }

    /**
     * Method under test: {@link SystemUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals28() {
        SystemUserMasterDto systemUserMasterDto = new SystemUserMasterDto();
        systemUserMasterDto.setAccessId("42");
        systemUserMasterDto.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setCreationId("42");
        systemUserMasterDto.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto.setModificationId("42");
        systemUserMasterDto.setNoOfAttempts((short) 1);
        systemUserMasterDto.setStatus("Status");
        systemUserMasterDto.setSystemId("42");
        systemUserMasterDto.setUserFullName("Dr Jane Doe");
        systemUserMasterDto.setUserIpRange("User Ip Range");
        systemUserMasterDto.setUserName("janedoe");
        systemUserMasterDto.setUserSecret(null);

        SystemUserMasterDto systemUserMasterDto2 = new SystemUserMasterDto();
        systemUserMasterDto2.setAccessId("42");
        systemUserMasterDto2.setCreationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setCreationId("42");
        systemUserMasterDto2.setInvalidAttemptDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLastLoginDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setLockedDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationDateTime(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        systemUserMasterDto2.setModificationId("42");
        systemUserMasterDto2.setNoOfAttempts((short) 1);
        systemUserMasterDto2.setStatus("Status");
        systemUserMasterDto2.setSystemId("42");
        systemUserMasterDto2.setUserFullName("Dr Jane Doe");
        systemUserMasterDto2.setUserIpRange("User Ip Range");
        systemUserMasterDto2.setUserName("janedoe");
        systemUserMasterDto2.setUserSecret("User Secret");
        assertNotEquals(systemUserMasterDto, systemUserMasterDto2);
    }
}

