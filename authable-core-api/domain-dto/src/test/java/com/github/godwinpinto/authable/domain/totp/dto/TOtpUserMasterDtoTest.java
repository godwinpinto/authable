package com.github.godwinpinto.authable.domain.totp.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TOtpUserMasterDtoTest {
    /**
     * Method under test: {@link TOtpUserMasterDto#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertFalse((new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime, invalidAttemptDateTime,
                lockedDateTime, "Access Type", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay())).canEqual("Other"));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertTrue(tOtpUserMasterDto.canEqual(new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime2, invalidAttemptDateTime2, lockedDateTime2, "Access Type", "Status", "42",
                modificationDateTime2, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay())));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserMasterDto#TOtpUserMasterDto(String, String, String, short, LocalDateTime, LocalDateTime, LocalDateTime, String, String, String, LocalDateTime, String, LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setAccessType(String)}
     *   <li>{@link TOtpUserMasterDto#setCreationDateTime(LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setCreationId(String)}
     *   <li>{@link TOtpUserMasterDto#setInvalidAttemptDateTime(LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setLastLoginDateTime(LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setLockedDateTime(LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setModificationDateTime(LocalDateTime)}
     *   <li>{@link TOtpUserMasterDto#setModificationId(String)}
     *   <li>{@link TOtpUserMasterDto#setNoOfAttempts(short)}
     *   <li>{@link TOtpUserMasterDto#setStatus(String)}
     *   <li>{@link TOtpUserMasterDto#setSystemId(String)}
     *   <li>{@link TOtpUserMasterDto#setUserId(String)}
     *   <li>{@link TOtpUserMasterDto#setUserSecret(String)}
     *   <li>{@link TOtpUserMasterDto#toString()}
     *   <li>{@link TOtpUserMasterDto#getAccessType()}
     *   <li>{@link TOtpUserMasterDto#getCreationDateTime()}
     *   <li>{@link TOtpUserMasterDto#getCreationId()}
     *   <li>{@link TOtpUserMasterDto#getInvalidAttemptDateTime()}
     *   <li>{@link TOtpUserMasterDto#getLastLoginDateTime()}
     *   <li>{@link TOtpUserMasterDto#getLockedDateTime()}
     *   <li>{@link TOtpUserMasterDto#getModificationDateTime()}
     *   <li>{@link TOtpUserMasterDto#getModificationId()}
     *   <li>{@link TOtpUserMasterDto#getNoOfAttempts()}
     *   <li>{@link TOtpUserMasterDto#getStatus()}
     *   <li>{@link TOtpUserMasterDto#getSystemId()}
     *   <li>{@link TOtpUserMasterDto#getUserId()}
     *   <li>{@link TOtpUserMasterDto#getUserSecret()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto actualTOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42", modificationDateTime,
                "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        actualTOtpUserMasterDto.setAccessType("Access Type");
        LocalDateTime creationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualTOtpUserMasterDto.setCreationDateTime(creationDateTime);
        actualTOtpUserMasterDto.setCreationId("42");
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualTOtpUserMasterDto.setInvalidAttemptDateTime(invalidAttemptDateTime2);
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualTOtpUserMasterDto.setLastLoginDateTime(lastLoginDateTime2);
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualTOtpUserMasterDto.setLockedDateTime(lockedDateTime2);
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        actualTOtpUserMasterDto.setModificationDateTime(modificationDateTime2);
        actualTOtpUserMasterDto.setModificationId("42");
        actualTOtpUserMasterDto.setNoOfAttempts((short) 1);
        actualTOtpUserMasterDto.setStatus("Status");
        actualTOtpUserMasterDto.setSystemId("42");
        actualTOtpUserMasterDto.setUserId("42");
        actualTOtpUserMasterDto.setUserSecret("User Secret");
        String actualToStringResult = actualTOtpUserMasterDto.toString();
        assertEquals("Access Type", actualTOtpUserMasterDto.getAccessType());
        assertSame(creationDateTime, actualTOtpUserMasterDto.getCreationDateTime());
        assertEquals("42", actualTOtpUserMasterDto.getCreationId());
        assertSame(invalidAttemptDateTime2, actualTOtpUserMasterDto.getInvalidAttemptDateTime());
        assertSame(lastLoginDateTime2, actualTOtpUserMasterDto.getLastLoginDateTime());
        assertSame(lockedDateTime2, actualTOtpUserMasterDto.getLockedDateTime());
        assertSame(modificationDateTime2, actualTOtpUserMasterDto.getModificationDateTime());
        assertEquals("42", actualTOtpUserMasterDto.getModificationId());
        assertEquals((short) 1, actualTOtpUserMasterDto.getNoOfAttempts());
        assertEquals("Status", actualTOtpUserMasterDto.getStatus());
        assertEquals("42", actualTOtpUserMasterDto.getSystemId());
        assertEquals("42", actualTOtpUserMasterDto.getUserId());
        assertEquals("User Secret", actualTOtpUserMasterDto.getUserSecret());
        assertEquals("TOtpUserMasterDto(userId=42, systemId=42, userSecret=User Secret, noOfAttempts=1, lastLoginDateTime"
                + "=1970-01-01T00:00, invalidAttemptDateTime=1970-01-01T00:00, lockedDateTime=1970-01-01T00:00,"
                + " accessType=Access Type, status=Status, modificationId=42, modificationDateTime=1970-01-01T00:00,"
                + " creationId=42, creationDateTime=1970-01-01T00:00)", actualToStringResult);
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime,
                invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay()), null);
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals2() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime,
                invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay()), "Different type to TOtpUserMasterDto");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserMasterDto#equals(Object)}
     *   <li>{@link TOtpUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        assertEquals(tOtpUserMasterDto, tOtpUserMasterDto);
        int expectedHashCodeResult = tOtpUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserMasterDto.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserMasterDto#equals(Object)}
     *   <li>{@link TOtpUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto2 = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime2, invalidAttemptDateTime2, lockedDateTime2, "Access Type", "Status", "42",
                modificationDateTime2, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());

        assertEquals(tOtpUserMasterDto, tOtpUserMasterDto2);
        int expectedHashCodeResult = tOtpUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserMasterDto2.hashCode());
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals5() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("User Secret", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals6() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto(null, "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals7() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "User Secret", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals8() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", null, "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals9() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "42", (short) 1, lastLoginDateTime,
                invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals10() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", null, (short) 1, lastLoginDateTime,
                invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals11() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 3,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals12() {
        LocalDateTime lastLoginDateTime = LocalDate.now()
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals13() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.now()
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals14() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.now()
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals15() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "42", "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals16() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, null, "Status", "42", modificationDateTime, "42",
                LocalDate.of(1970, 1, 1)
                        .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals17() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "42", "42", modificationDateTime,
                "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals18() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", null, "42", modificationDateTime,
                "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals19() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "User Secret",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals20() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", null,
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals21() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.now()
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals22() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "User Secret", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals23() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, null, LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Method under test: {@link TOtpUserMasterDto#equals(Object)}
     */
    @Test
    void testEquals24() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.now()
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        assertNotEquals(tOtpUserMasterDto,
                new TOtpUserMasterDto("42", "42", "User Secret", (short) 1, lastLoginDateTime2, invalidAttemptDateTime2,
                        lockedDateTime2, "Access Type", "Status", "42", modificationDateTime2, "42",
                        LocalDate.of(1970, 1, 1)
                                .atStartOfDay()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserMasterDto#equals(Object)}
     *   <li>{@link TOtpUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals25() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto(null, "42", "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto2 = new TOtpUserMasterDto(null, "42", "User Secret", (short) 1,
                lastLoginDateTime2, invalidAttemptDateTime2, lockedDateTime2, "Access Type", "Status", "42",
                modificationDateTime2, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());

        assertEquals(tOtpUserMasterDto, tOtpUserMasterDto2);
        int expectedHashCodeResult = tOtpUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserMasterDto2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserMasterDto#equals(Object)}
     *   <li>{@link TOtpUserMasterDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals26() {
        LocalDateTime lastLoginDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto = new TOtpUserMasterDto("42", null, "User Secret", (short) 1,
                lastLoginDateTime, invalidAttemptDateTime, lockedDateTime, "Access Type", "Status", "42",
                modificationDateTime, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        LocalDateTime lastLoginDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime invalidAttemptDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime lockedDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        LocalDateTime modificationDateTime2 = LocalDate.of(1970, 1, 1)
                .atStartOfDay();
        TOtpUserMasterDto tOtpUserMasterDto2 = new TOtpUserMasterDto("42", null, "User Secret", (short) 1,
                lastLoginDateTime2, invalidAttemptDateTime2, lockedDateTime2, "Access Type", "Status", "42",
                modificationDateTime2, "42", LocalDate.of(1970, 1, 1)
                .atStartOfDay());

        assertEquals(tOtpUserMasterDto, tOtpUserMasterDto2);
        int expectedHashCodeResult = tOtpUserMasterDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserMasterDto2.hashCode());
    }

}

