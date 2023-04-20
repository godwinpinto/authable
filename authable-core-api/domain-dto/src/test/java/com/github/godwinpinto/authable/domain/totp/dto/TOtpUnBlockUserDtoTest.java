package com.github.godwinpinto.authable.domain.totp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TOtpUnBlockUserDtoTest {
    /**
     * Method under test: {@link TOtpUnBlockUserDto#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new TOtpUnBlockUserDto("Status Code", "Status Description")).canEqual("Other"));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "Status Description");
        assertTrue(tOtpUnBlockUserDto.canEqual(new TOtpUnBlockUserDto("Status Code", "Status Description")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#TOtpUnBlockUserDto()}
     *   <li>{@link TOtpUnBlockUserDto#setStatusCode(String)}
     *   <li>{@link TOtpUnBlockUserDto#setStatusDescription(String)}
     *   <li>{@link TOtpUnBlockUserDto#toString()}
     *   <li>{@link TOtpUnBlockUserDto#getStatusCode()}
     *   <li>{@link TOtpUnBlockUserDto#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TOtpUnBlockUserDto actualTOtpUnBlockUserDto = new TOtpUnBlockUserDto();
        actualTOtpUnBlockUserDto.setStatusCode("Status Code");
        actualTOtpUnBlockUserDto.setStatusDescription("Status Description");
        String actualToStringResult = actualTOtpUnBlockUserDto.toString();
        assertEquals("Status Code", actualTOtpUnBlockUserDto.getStatusCode());
        assertEquals("Status Description", actualTOtpUnBlockUserDto.getStatusDescription());
        assertEquals("TOtpUnBlockUserDto(statusCode=Status Code, statusDescription=Status Description)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#TOtpUnBlockUserDto(String, String)}
     *   <li>{@link TOtpUnBlockUserDto#setStatusCode(String)}
     *   <li>{@link TOtpUnBlockUserDto#setStatusDescription(String)}
     *   <li>{@link TOtpUnBlockUserDto#toString()}
     *   <li>{@link TOtpUnBlockUserDto#getStatusCode()}
     *   <li>{@link TOtpUnBlockUserDto#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        TOtpUnBlockUserDto actualTOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "Status Description");
        actualTOtpUnBlockUserDto.setStatusCode("Status Code");
        actualTOtpUnBlockUserDto.setStatusDescription("Status Description");
        String actualToStringResult = actualTOtpUnBlockUserDto.toString();
        assertEquals("Status Code", actualTOtpUnBlockUserDto.getStatusCode());
        assertEquals("Status Description", actualTOtpUnBlockUserDto.getStatusDescription());
        assertEquals("TOtpUnBlockUserDto(statusCode=Status Code, statusDescription=Status Description)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new TOtpUnBlockUserDto("Status Code", "Status Description"), null);
        assertNotEquals(new TOtpUnBlockUserDto("Status Code", "Status Description"),
                "Different type to TOtpUnBlockUserDto");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#equals(Object)}
     *   <li>{@link TOtpUnBlockUserDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "Status Description");
        assertEquals(tOtpUnBlockUserDto, tOtpUnBlockUserDto);
        int expectedHashCodeResult = tOtpUnBlockUserDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUnBlockUserDto.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#equals(Object)}
     *   <li>{@link TOtpUnBlockUserDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "Status Description");
        TOtpUnBlockUserDto tOtpUnBlockUserDto2 = new TOtpUnBlockUserDto("Status Code", "Status Description");

        assertEquals(tOtpUnBlockUserDto, tOtpUnBlockUserDto2);
        int expectedHashCodeResult = tOtpUnBlockUserDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUnBlockUserDto2.hashCode());
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#equals(Object)}
     */
    @Test
    void testEquals4() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Description", "Status Description");
        assertNotEquals(tOtpUnBlockUserDto, new TOtpUnBlockUserDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#equals(Object)}
     */
    @Test
    void testEquals5() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto(null, "Status Description");
        assertNotEquals(tOtpUnBlockUserDto, new TOtpUnBlockUserDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#equals(Object)}
     */
    @Test
    void testEquals6() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "Status Code");
        assertNotEquals(tOtpUnBlockUserDto, new TOtpUnBlockUserDto("Status Code", "Status Description"));
    }

    /**
     * Method under test: {@link TOtpUnBlockUserDto#equals(Object)}
     */
    @Test
    void testEquals7() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", null);
        assertNotEquals(tOtpUnBlockUserDto, new TOtpUnBlockUserDto("Status Code", "Status Description"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#equals(Object)}
     *   <li>{@link TOtpUnBlockUserDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals8() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto(null, "Status Description");
        TOtpUnBlockUserDto tOtpUnBlockUserDto2 = new TOtpUnBlockUserDto(null, "Status Description");

        assertEquals(tOtpUnBlockUserDto, tOtpUnBlockUserDto2);
        int expectedHashCodeResult = tOtpUnBlockUserDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUnBlockUserDto2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TOtpUnBlockUserDto#equals(Object)}
     *   <li>{@link TOtpUnBlockUserDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals9() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", null);
        TOtpUnBlockUserDto tOtpUnBlockUserDto2 = new TOtpUnBlockUserDto("Status Code", null);

        assertEquals(tOtpUnBlockUserDto, tOtpUnBlockUserDto2);
        int expectedHashCodeResult = tOtpUnBlockUserDto.hashCode();
        assertEquals(expectedHashCodeResult, tOtpUnBlockUserDto2.hashCode());
    }

    @Test
    void testBuilder() {
        TOtpUnBlockUserDto tOtpUnBlockUserDto = new TOtpUnBlockUserDto("Status Code", "DESCRIPTION");
        TOtpUnBlockUserDto tOtpUnBlockUserDto2 = TOtpUnBlockUserDto.builder()
                .statusCode("Status Code")
                .statusDescription("DESCRIPTION")
                .build();

        assertEquals(tOtpUnBlockUserDto, tOtpUnBlockUserDto2);
    }
}

