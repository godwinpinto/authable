package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoAlgorithmsAdapter implements CryptoAlgorithmsSPI {

    /**
     * This method performs a SHA512 to create a string output
     * by concatenating salt, pipe and the provided secret
     *
     * @param systemId is the key to randomize output also called salt
     * @param secret   is the password
     * @return hashed string
     */


    public String generateHashFromSecret(String systemId, String userId, String secret) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] bytes =
                    md.digest((systemId + ApplicationConstants.SECRET_SEPARATOR + userId + ApplicationConstants.SECRET_SEPARATOR + secret).getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
