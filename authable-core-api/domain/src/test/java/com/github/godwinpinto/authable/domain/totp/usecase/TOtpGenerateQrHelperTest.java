package com.github.godwinpinto.authable.domain.totp.usecase;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TOtpGenerateQrHelper.class})
@ExtendWith(SpringExtension.class)
class TOtpGenerateQrHelperTest {
    @MockBean
    private TOtpCryptoSPI tOtpCryptoSPI;

    @Autowired
    private TOtpGenerateQrHelper tOtpGenerateQrHelper;

    @MockBean
    private TOtpUserMasterSPI tOtpUserMasterSPI;

    /**
     * Method under test: {@link TOtpGenerateQrHelper#canGenerateQr(TOtpUserMasterDto)}
     */
    @Test
    void testCanGenerateQr() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("Status");
        tOtpGenerateQrHelper.canGenerateQr(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#canGenerateQr(TOtpUserMasterDto)}
     */
    @Test
    void testCanGenerateQr2() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("D");
        tOtpGenerateQrHelper.canGenerateQr(user);
        verify(user).getStatus();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#canGenerateQr(TOtpUserMasterDto)}
     */
    @Test
    void testCanGenerateQr3() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("A");
        tOtpGenerateQrHelper.canGenerateQr(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#canGenerateQr(TOtpUserMasterDto)}
     */
    @Test
    void testCanGenerateQr4() {
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getStatus()).thenReturn("N");
        tOtpGenerateQrHelper.canGenerateQr(user);
        verify(user, atLeast(1)).getStatus();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#generateQr(String, TOtpUserMasterDto)}
     */
    @Test
    void testGenerateQr() {
        when(tOtpCryptoSPI.generateQRCode(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any())).thenReturn("Generate QRCode");
        TOtpUserMasterDto user = mock(TOtpUserMasterDto.class);
        when(user.getUserSecret()).thenReturn("User Secret");
        tOtpGenerateQrHelper.generateQr("42", user);
        verify(tOtpCryptoSPI).generateQRCode(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<String>any());
        verify(user).getUserSecret();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#formatNoSubscriptionMessage()}
     */
    @Test
    void testFormatNoSubscriptionMessage() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpGenerateQrHelper.formatNoSubscriptionMessage();
    }

    /**
     * Method under test: {@link TOtpGenerateQrHelper#fallbackMethod(Throwable)}
     */
    @Test
    void testFallbackMethod() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        tOtpGenerateQrHelper.fallbackMethod(new Throwable());
    }
}

