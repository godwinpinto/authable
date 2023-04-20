package com.github.godwinpinto.authable.domain.totp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TOtpUserStatusDtoTest {
    /**
     * Method under test: {@link TOtpUserStatusDto#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new TOtpUserStatusDto("Status Code", "Status Description")).canEqual("Other"));
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "Status Description");
        assertTrue(tOtpUserStatusDto.canEqual(new TOtpUserStatusDto("Status Code", "Status Description")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#TOtpUserStatusDto()}
     *   <li>{@link TOtpUserStatusDto#setStatusCode(String)}
     *   <li>{@link TOtpUserStatusDto#setStatusDescription(String)}
     *   <li>{@link TOtpUserStatusDto#toString()}
     *   <li>{@link TOtpUserStatusDto#getStatusCode()}
     *   <li>{@link TOtpUserStatusDto#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TOtpUserStatusDto actualTOtpUserStatusDto = new TOtpUserStatusDto();
        actualTOtpUserStatusDto.setStatusCode("Status Code");
        actualTOtpUserStatusDto.setStatusDescription("Status Description");
        String actualToStringResult = actualTOtpUserStatusDto.toString();
        assertEquals("Status Code", actualTOtpUserStatusDto.getStatusCode());
        assertEquals("Status Description", actualTOtpUserStatusDto.getStatusDescription());
        assertEquals("TOtpUserStatusDto(statusCode=Status Code, statusDescription=Status Description)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#TOtpUserStatusDto(String, String)}
     *   <li>{@link TOtpUserStatusDto#setStatusCode(String)}
     *   <li>{@link TOtpUserStatusDto#setStatusDescription(String)}
     *   <li>{@link TOtpUserStatusDto#toString()}
     *   <li>{@link TOtpUserStatusDto#getStatusCode()}
     *   <li>{@link TOtpUserStatusDto#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TOtpUserStatusDto actualTOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "Status Description");
        actualTOtpUserStatusDto.setStatusCode("Status Code");
        actualTOtpUserStatusDto.setStatusDescription("Status Description");
        String actualToStringResult = actualTOtpUserStatusDto.toString();
        assertEquals("Status Code", actualTOtpUserStatusDto.getStatusCode());
        assertEquals("Status Description", actualTOtpUserStatusDto.getStatusDescription());
        assertEquals("TOtpUserStatusDto(statusCode=Status Code, statusDescription=Status Description)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TOtpUserStatusDto("Status Code", "Status Description"), null);
        assertNotEquals(new TOtpUserStatusDto("Status Code", "Status Description"),
                "Different type to TOtpUserStatusDto");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#equals(Object)}
     *   <li>{@link TOtpUserStatusDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "Status Description");
        assertEquals(tOtpUserStatusDto, tOtpUserStatusDto);
        int expectedHashCodeResult = tOtpUserStatusDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserStatusDto.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#equals(Object)}
     *   <li>{@link TOtpUserStatusDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "Status Description");
        TOtpUserStatusDto tOtpUserStatusDto2 = new TOtpUserStatusDto("Status Code", "Status Description");

        assertEquals(tOtpUserStatusDto, tOtpUserStatusDto2);
        int expectedHashCodeResult = tOtpUserStatusDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserStatusDto2.hashCode());
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#equals(Object)}
     */
    @Test
    void testEquals4() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Description", "Status Description");
        assertNotEquals(tOtpUserStatusDto, new TOtpUserStatusDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#equals(Object)}
     */
    @Test
    void testEquals5() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto(null, "Status Description");
        assertNotEquals(tOtpUserStatusDto, new TOtpUserStatusDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#equals(Object)}
     */
    @Test
    void testEquals6() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "Status Code");
        assertNotEquals(tOtpUserStatusDto, new TOtpUserStatusDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUserStatusDto#equals(Object)}
     */
    @Test
    void testEquals7() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", null);
        assertNotEquals(tOtpUserStatusDto, new TOtpUserStatusDto("Status Code", "Status Description"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#equals(Object)}
     *   <li>{@link TOtpUserStatusDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto(null, "Status Description");
        TOtpUserStatusDto tOtpUserStatusDto2 = new TOtpUserStatusDto(null, "Status Description");

        assertEquals(tOtpUserStatusDto, tOtpUserStatusDto2);
        int expectedHashCodeResult = tOtpUserStatusDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserStatusDto2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUserStatusDto#equals(Object)}
     *   <li>{@link TOtpUserStatusDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", null);
        TOtpUserStatusDto tOtpUserStatusDto2 = new TOtpUserStatusDto("Status Code", null);

        assertEquals(tOtpUserStatusDto, tOtpUserStatusDto2);
        int expectedHashCodeResult = tOtpUserStatusDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUserStatusDto2.hashCode());
    }

    @Test
    void testBuilder() {
        TOtpUserStatusDto tOtpUserStatusDto = new TOtpUserStatusDto("Status Code", "DESCRIPTION");
        TOtpUserStatusDto tOtpUserStatusDto2 = TOtpUserStatusDto.builder()
                .statusCode("Status Code")
                .statusDescription("DESCRIPTION")
                .build();

        assertEquals(tOtpUserStatusDto, tOtpUserStatusDto2);
    }
}

