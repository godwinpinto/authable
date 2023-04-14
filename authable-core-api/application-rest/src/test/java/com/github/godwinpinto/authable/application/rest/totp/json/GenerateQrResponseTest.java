package com.github.godwinpinto.authable.application.rest.totp.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class GenerateQrResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#GenerateQrResponse()}
     *   <li>{@link GenerateQrResponse#setQrImage(String)}
     *   <li>{@link GenerateQrResponse#setStatusCode(String)}
     *   <li>{@link GenerateQrResponse#setStatusDescription(String)}
     *   <li>{@link GenerateQrResponse#toString()}
     *   <li>{@link GenerateQrResponse#getQrImage()}
     *   <li>{@link GenerateQrResponse#getStatusCode()}
     *   <li>{@link GenerateQrResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor() {
        GenerateQrResponse actualGenerateQrResponse = new GenerateQrResponse();
        actualGenerateQrResponse.setQrImage("Qr Image");
        actualGenerateQrResponse.setStatusCode("Status Code");
        actualGenerateQrResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualGenerateQrResponse.toString();
        assertEquals("Qr Image", actualGenerateQrResponse.getQrImage());
        assertEquals("Status Code", actualGenerateQrResponse.getStatusCode());
        assertEquals("Status Description", actualGenerateQrResponse.getStatusDescription());
        assertEquals("GenerateQrResponse(statusCode=Status Code, statusDescription=Status Description, qrImage=Qr Image)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#GenerateQrResponse(String, String, String)}
     *   <li>{@link GenerateQrResponse#setQrImage(String)}
     *   <li>{@link GenerateQrResponse#setStatusCode(String)}
     *   <li>{@link GenerateQrResponse#setStatusDescription(String)}
     *   <li>{@link GenerateQrResponse#toString()}
     *   <li>{@link GenerateQrResponse#getQrImage()}
     *   <li>{@link GenerateQrResponse#getStatusCode()}
     *   <li>{@link GenerateQrResponse#getStatusDescription()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        GenerateQrResponse actualGenerateQrResponse = new GenerateQrResponse("Status Code", "Status Description",
                "Qr Image");
        actualGenerateQrResponse.setQrImage("Qr Image");
        actualGenerateQrResponse.setStatusCode("Status Code");
        actualGenerateQrResponse.setStatusDescription("Status Description");
        String actualToStringResult = actualGenerateQrResponse.toString();
        assertEquals("Qr Image", actualGenerateQrResponse.getQrImage());
        assertEquals("Status Code", actualGenerateQrResponse.getStatusCode());
        assertEquals("Status Description", actualGenerateQrResponse.getStatusDescription());
        assertEquals("GenerateQrResponse(statusCode=Status Code, statusDescription=Status Description, qrImage=Qr Image)",
                actualToStringResult);
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new GenerateQrResponse("Status Code", "Status Description", "Qr Image"), null);
        assertNotEquals(new GenerateQrResponse("Status Code", "Status Description", "Qr Image"),
                "Different type to GenerateQrResponse");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#equals(Object)}
     *   <li>{@link GenerateQrResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Description", "Qr Image");
        assertEquals(generateQrResponse, generateQrResponse);
        int expectedHashCodeResult = generateQrResponse.hashCode();
        assertEquals(expectedHashCodeResult, generateQrResponse.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#equals(Object)}
     *   <li>{@link GenerateQrResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Description", "Qr Image");
        GenerateQrResponse generateQrResponse2 =
                new GenerateQrResponse("Status Code", "Status Description", "Qr Image");

        assertEquals(generateQrResponse, generateQrResponse2);
        int expectedHashCodeResult = generateQrResponse.hashCode();
        assertEquals(expectedHashCodeResult, generateQrResponse2.hashCode());
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals4() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Description", "Status Description",
                "Qr Image");
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals5() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse(null, "Status Description", "Qr Image");
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals6() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Code", "Qr Image");
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals7() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", null, "Qr Image");
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals8() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Description",
                "Status Code");
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Method under test: {@link GenerateQrResponse#equals(Object)}
     */
    @Test
    void testEquals9() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Description", null);
        assertNotEquals(generateQrResponse, new GenerateQrResponse("Status Code", "Status Description", "Qr Image"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#equals(Object)}
     *   <li>{@link GenerateQrResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals10() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse(null, "Status Description", "Qr Image");
        GenerateQrResponse generateQrResponse2 = new GenerateQrResponse(null, "Status Description", "Qr Image");

        assertEquals(generateQrResponse, generateQrResponse2);
        int expectedHashCodeResult = generateQrResponse.hashCode();
        assertEquals(expectedHashCodeResult, generateQrResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#equals(Object)}
     *   <li>{@link GenerateQrResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", null, "Qr Image");
        GenerateQrResponse generateQrResponse2 = new GenerateQrResponse("Status Code", null, "Qr Image");

        assertEquals(generateQrResponse, generateQrResponse2);
        int expectedHashCodeResult = generateQrResponse.hashCode();
        assertEquals(expectedHashCodeResult, generateQrResponse2.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GenerateQrResponse#equals(Object)}
     *   <li>{@link GenerateQrResponse#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        GenerateQrResponse generateQrResponse = new GenerateQrResponse("Status Code", "Status Description", null);
        GenerateQrResponse generateQrResponse2 = new GenerateQrResponse("Status Code", "Status Description", null);

        assertEquals(generateQrResponse, generateQrResponse2);
        int expectedHashCodeResult = generateQrResponse.hashCode();
        assertEquals(expectedHashCodeResult, generateQrResponse2.hashCode());
    }
}

