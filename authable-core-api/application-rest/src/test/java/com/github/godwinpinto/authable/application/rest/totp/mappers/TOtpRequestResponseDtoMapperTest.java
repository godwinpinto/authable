package com.github.godwinpinto.authable.application.rest.totp.mappers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class TOtpRequestResponseDtoMapperTest {

    @Test
    void createNewResponseFromDto_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.createNewResponseFromDto(null));
    }

    @Test
    void unblockResponseFromDto_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.unblockResponseFromDto(null));
    }

    @Test
    void unSubscribeResponseFromDto_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.unSubscribeResponseFromDto(null));
    }

    @Test
    void statusResponseFromDtoo_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.statusResponseFromDto(null));
    }

    @Test
    void verifyResponseFromDto_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.verifyResponseFromDto(null));
    }

    @Test
    void generateQrResponseFromDto_Null_Test() {
        assertNull(TOtpRequestResponseDtoMapper.INSTANCE.generateQrResponseFromDto(null));
    }
}
