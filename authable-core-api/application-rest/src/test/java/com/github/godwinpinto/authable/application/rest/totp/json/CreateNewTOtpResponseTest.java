package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CreateNewTOtpResponseTest {
    /**
     * Method under test: {@link CreateNewTOtpResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse(
                (new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"))
                        .canEqual("Other"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertTrue(createNewTOtpResponse.canEqual(
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#CreateNewTOtpResponse()}
     *   <li>{@link CreateNewTOtpResponse#setSecretKey(String)}
     *   <li>{@link CreateNewTOtpResponse#setStatusCode(String)}
     *   <li>{@link CreateNewTOtpResponse#setStatusDescription(String)}
     *   <li>{@link CreateNewTOtpResponse#toString()}
     *   <li>{@link CreateNewTOtpResponse#getSecretKey()}
     *   <li>{@link CreateNewTOtpResponse#getStatusCode()}
     *   <li>{@link CreateNewTOtpResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CreateNewTOtpResponse actualCreateNewTOtpResponse = new CreateNewTOtpResponse();
        actualCreateNewTOtpResponse.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualCreateNewTOtpResponse.setStatusCode("Status Code");
        actualCreateNewTOtpResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualCreateNewTOtpResponse.toString();
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualCreateNewTOtpResponse.getSecretKey());
        assertEquals("Status Code", actualCreateNewTOtpResponse.getStatusCode());
        assertEquals("Status Description", actualCreateNewTOtpResponse.getStatusDescription());
        assertEquals("CreateNewTOtpResponse(statusCode=Status Code, statusDescription=Status Description, secretKey"
                + "=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#CreateNewTOtpResponse(String, String, String)}
     *   <li>{@link CreateNewTOtpResponse#setSecretKey(String)}
     *   <li>{@link CreateNewTOtpResponse#setStatusCode(String)}
     *   <li>{@link CreateNewTOtpResponse#setStatusDescription(String)}
     *   <li>{@link CreateNewTOtpResponse#toString()}
     *   <li>{@link CreateNewTOtpResponse#getSecretKey()}
     *   <li>{@link CreateNewTOtpResponse#getStatusCode()}
     *   <li>{@link CreateNewTOtpResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        CreateNewTOtpResponse actualCreateNewTOtpResponse =
                new CreateNewTOtpResponse("Status Code", "Status Description",
                        "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualCreateNewTOtpResponse.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        actualCreateNewTOtpResponse.setStatusCode("Status Code");
        actualCreateNewTOtpResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualCreateNewTOtpResponse.toString();
        assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualCreateNewTOtpResponse.getSecretKey());
        assertEquals("Status Code", actualCreateNewTOtpResponse.getStatusCode());
        assertEquals("Status Description", actualCreateNewTOtpResponse.getStatusDescription());
        assertEquals("CreateNewTOtpResponse(statusCode=Status Code, statusDescription=Status Description, secretKey"
                + "=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY)", actualToStringResult);
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
                null);
        assertNotEquals(
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"),
                "Different type to CreateNewTOtpResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#equals(Object)}
     *   <li>{@link CreateNewTOtpResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertEquals(createNewTOtpResponse, createNewTOtpResponse);
        int expectedHashCodeResult = createNewTOtpResponse.hashCode();
        assertEquals(expectedHashCodeResult, createNewTOtpResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#equals(Object)}
     *   <li>{@link CreateNewTOtpResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        CreateNewTOtpResponse createNewTOtpResponse2 = new CreateNewTOtpResponse("Status Code", "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

        assertEquals(createNewTOtpResponse, createNewTOtpResponse2);
        int expectedHashCodeResult = createNewTOtpResponse.hashCode();
        assertEquals(expectedHashCodeResult, createNewTOtpResponse2.hashCode());
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Description",
                "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Code",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                "Status Code");
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Method under test: {@link CreateNewTOtpResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                null);
        assertNotEquals(createNewTOtpResponse,
                new CreateNewTOtpResponse("Status Code", "Status Description", "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#equals(Object)}
     *   <li>{@link CreateNewTOtpResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        CreateNewTOtpResponse createNewTOtpResponse2 = new CreateNewTOtpResponse(null, "Status Description",
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

        assertEquals(createNewTOtpResponse, createNewTOtpResponse2);
        int expectedHashCodeResult = createNewTOtpResponse.hashCode();
        assertEquals(expectedHashCodeResult, createNewTOtpResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#equals(Object)}
     *   <li>{@link CreateNewTOtpResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
        CreateNewTOtpResponse createNewTOtpResponse2 = new CreateNewTOtpResponse("Status Code", null,
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

        assertEquals(createNewTOtpResponse, createNewTOtpResponse2);
        int expectedHashCodeResult = createNewTOtpResponse.hashCode();
        assertEquals(expectedHashCodeResult, createNewTOtpResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CreateNewTOtpResponse#equals(Object)}
     *   <li>{@link CreateNewTOtpResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        CreateNewTOtpResponse createNewTOtpResponse = new CreateNewTOtpResponse("Status Code", "Status Description",
                null);
        CreateNewTOtpResponse createNewTOtpResponse2 = new CreateNewTOtpResponse("Status Code", "Status Description",
                null);

        assertEquals(createNewTOtpResponse, createNewTOtpResponse2);
        int expectedHashCodeResult = createNewTOtpResponse.hashCode();
        assertEquals(expectedHashCodeResult, createNewTOtpResponse2.hashCode());
    }
}

