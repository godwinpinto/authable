package com.github.godwinpinto.authable.orchestration.config;

import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpCryptoSPI;
import com.github.godwinpinto.authable.infrastructure.crypto.adapters.CryptoAlgorithmsAdapter;
import com.github.godwinpinto.authable.infrastructure.crypto.adapters.JWTUtilAdapter;
import com.github.godwinpinto.authable.infrastructure.crypto.adapters.TOtpCryptoAdapter;
import com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpSecretEncryption;
import com.github.godwinpinto.authable.infrastructure.crypto.service.TOtpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SPICryptoBeanConfiguration {

  private JWTUtilService jwtUtilService;

  private TOtpService tOtpService;

  private TOtpSecretEncryption tOtpSecretEncryption;

  public SPICryptoBeanConfiguration(
      JWTUtilService jwtUtilService,
      TOtpService tOtpService,
      TOtpSecretEncryption tOtpSecretEncryption) {
    this.jwtUtilService = jwtUtilService;
    this.tOtpService = tOtpService;
    this.tOtpSecretEncryption = tOtpSecretEncryption;
  }

  @Bean
  public JWTUtilSPI jwtUtilspi() {
    return new JWTUtilAdapter(jwtUtilService);
  }

  @Bean
  public CryptoAlgorithmsSPI cryptoAlgorithmsSPI() {
    return new CryptoAlgorithmsAdapter();
  }

  @Bean
  public TOtpCryptoSPI tOtpCryptoSPI() {
    return new TOtpCryptoAdapter(tOtpService, tOtpSecretEncryption);
  }
}
