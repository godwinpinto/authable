package com.github.godwinpinto.authable.infrastructure.crypto.service;

import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TOtpSecretEncryption {

  Logger logger = LoggerFactory.getLogger(TOtpSecretEncryption.class);

  @Value("${infrastructure-crypto.totp.secret-key}")
  private String secretKey;

  public String encrypt(String salt, String strToEncrypt) {
    try {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      byte[] iv = new byte[12];
      SecureRandom random = new SecureRandom();
      random.nextBytes(iv);
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
      cipher.init(Cipher.ENCRYPT_MODE, getSecretKeySpecs(salt), parameterSpec);

      byte[] cipherText = cipher.doFinal(strToEncrypt.getBytes());
      byte[] cipherTextWithIv =
          ByteBuffer.allocate(iv.length + cipherText.length).put(iv).put(cipherText).array();

      return Base64.getEncoder().encodeToString(cipherTextWithIv);
    } catch (Exception e) {
      logger.error("Error in encryption", e);
    }
    return null;
  }

  public String decrypt(String salt, String strToDecrypt) {
    try {

      byte[] cipherText = Base64.getDecoder().decode(strToDecrypt);
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, cipherText, 0, 12);
      cipher.init(Cipher.DECRYPT_MODE, getSecretKeySpecs(salt), parameterSpec);
      return new String(cipher.doFinal(cipherText, 12, cipherText.length - 12));
    } catch (Exception e) {
      logger.error("Error in encryption", e);
    }
    return null;
  }

  private SecretKey getSecretKeySpecs(String salt)
      throws InvalidKeySpecException, NoSuchAlgorithmException {
    byte[] newSalt = StringUtils.rightPad(salt, 16, " ").substring(0, 16).getBytes();
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), newSalt, 65536, 256);
    byte[] keyBytes = factory.generateSecret(spec).getEncoded();
    return new SecretKeySpec(keyBytes, "AES");
  }
}
