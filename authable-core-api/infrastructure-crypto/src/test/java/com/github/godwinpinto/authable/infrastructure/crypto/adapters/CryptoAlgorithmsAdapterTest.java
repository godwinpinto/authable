package com.github.godwinpinto.authable.infrastructure.crypto.adapters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CryptoAlgorithmsAdapterTest {
    /**
     * Method under test: {@link CryptoAlgorithmsAdapter#generateHashFromSecret(String, String, String)}
     */
    @Test
    void testGenerateHashFromSecret() {
        assertEquals(
                "ba67705c133a87bc1cfbe126cae4778d1aa5355539ca323298c6c7651c3dca5516e0d395b50bd66e407f85b010cefcfd1a89"
                        + "d5b67fd59eb2c548e19d9207d27d",
                (new CryptoAlgorithmsAdapter()).generateHashFromSecret("42", "42", "Secret"));
    }
}

