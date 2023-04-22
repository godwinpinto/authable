package com.github.godwinpinto.authable.domain.ports.spi.impl;

import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;
import org.springframework.stereotype.Component;

@Component
public class CryptoAlgorithmsSPIImpl implements CryptoAlgorithmsSPI {
  @Override
  public String generateHashFromSecret(String systemId, String userId, String secret) {
    return null;
  }
}
