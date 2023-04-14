package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatusResponseTest {
    /**
     * Method under test: {@link StatusResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"))
                .canEqual("Other"));
    }

    /**
     * Method under test: {@link StatusResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertTrue(statusResponse.canEqual(
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StatusResponse#StatusResponse()}
     *   <li>{@link StatusResponse#setSecretKey(String)}
     *   <li>{@link StatusResponse#setStatusCode(String)}
     *   <li>{@link StatusResponse#setStatusDescription(String)}
     *   <li>{@link StatusResponse#toString()}
     *   <li>{@link StatusResponse#getSecretKey()}
     *   <li>{@link StatusResponse#getStatusCode()}
     *   <li>{@link StatusResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StatusResponse actualStatusResponse = new StatusResponse();
        actualStatusResponse.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualStatusResponse.setStatusCode("Status Code");
        actualStatusResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualStatusResponse.toString();
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualStatusResponse.getSecretKey());
        assertEquals("Status Code", actualStatusResponse.getStatusCode());
        assertEquals("Status Description", actualStatusResponse.getStatusDescription());
        assertEquals("StatusResponse(statusCode=Status Code, statusDescription=Status Description, secretKey=EXAMPLEKEYwja"
                + "lrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StatusResponse#StatusResponse(String, String, String)}
     *   <li>{@link StatusResponse#setSecretKey(String)}
     *   <li>{@link StatusResponse#setStatusCode(String)}
     *   <li>{@link StatusResponse#setStatusDescription(String)}
     *   <li>{@link StatusResponse#toString()}
     *   <li>{@link StatusResponse#getSecretKey()}
     *   <li>{@link StatusResponse#getStatusCode()}
     *   <li>{@link StatusResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        StatusResponse actualStatusResponse = new StatusResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualStatusResponse.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualStatusResponse.setStatusCode("Status Code");
        actualStatusResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualStatusResponse.toString();
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualStatusResponse.getSecretKey());
        assertEquals("Status Code", actualStatusResponse.getStatusCode());
        assertEquals("Status Description", actualStatusResponse.getStatusDescription());
        assertEquals(
                "StatusResponse(statusCode=Status Code, statusDescription=Status Description, secretKey=EXAMPLEKEYwja"
                        + "lrXUtnFEMI/K7MDENG/bPxRfiCY)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"), null);
        assertNotEquals(
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
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
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
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
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        StatusResponse statusResponse2 = new StatusResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

        assertEquals(statusResponse, statusResponse2);
        int expectedHashCodeResult = statusResponse.hashCode();
        assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        StatusResponse statusResponse = new StatusResponse("Status Description", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        StatusResponse statusResponse = new StatusResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Code",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        StatusResponse statusResponse = new StatusResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description", "Status Code");
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link StatusResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description", null);
        assertNotEquals(statusResponse,
                new StatusResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
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
        StatusResponse statusResponse = new StatusResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        StatusResponse statusResponse2 = new StatusResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

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
        StatusResponse statusResponse = new StatusResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        StatusResponse statusResponse2 = new StatusResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

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
        StatusResponse statusResponse = new StatusResponse("Status Code", "Status Description", null);
        StatusResponse statusResponse2 = new StatusResponse("Status Code", "Status Description", null);

        assertEquals(statusResponse, statusResponse2);
        int expectedHashCodeResult = statusResponse.hashCode();
        assertEquals(expectedHashCodeResult, statusResponse2.hashCode());
    }
}

