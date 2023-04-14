package com.github.godwinpinto.authable.domain.security.ports.spi;

public interface CryptoAlgorithmsSPI {
    public String generateHashFromSecret(String systemId, String userId, String secret);
}
