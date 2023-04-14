package com.github.godwinpinto.authable.infrastructure.crypto;


import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import dev.samstevens.totp.exceptions.CodeGenerationException;

@SpringJUnitConfig
public class TOtpServiceTest {

//    TOtpService service=new TOtpService();

    @Test
    public void generateHashFromString_Test(){

        /*assertDoesNotThrow(()->{
            String totp=service.generateTOtp();
            assertEquals(totp,"d");
        });
*/

    }
}
