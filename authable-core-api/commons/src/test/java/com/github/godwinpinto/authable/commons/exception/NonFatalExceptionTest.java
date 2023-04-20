package com.github.godwinpinto.authable.commons.exception;

import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonFatalExceptionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NonFatalException#NonFatalException()}
     *   <li>{@link NonFatalException#getErrCode()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertNotNull((new NonFatalException()).getErrCode());
        assertNotNull((new NonFatalException("An error occurred")).getErrCode());
        assertEquals("Err Code", (new NonFatalException("Err Code", "An error occurred")).getErrCode());
        assertEquals("Err Code",
                (new NonFatalException("Err Code", "An error occurred", new Throwable())).getErrCode());
        assertNotNull((new NonFatalException("An error occurred", new Throwable())).getErrCode());
    }
}

