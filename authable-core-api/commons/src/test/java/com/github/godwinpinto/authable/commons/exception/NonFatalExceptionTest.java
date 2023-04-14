package com.github.godwinpinto.authable.commons.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

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
        assertNull((new NonFatalException()).getErrCode());
        assertNull((new NonFatalException("An error occurred")).getErrCode());
        assertEquals("Err Code", (new NonFatalException("Err Code", "An error occurred")).getErrCode());
        assertEquals("Err Code",
                (new NonFatalException("Err Code", "An error occurred", new Throwable())).getErrCode());
        assertNull((new NonFatalException("An error occurred", new Throwable())).getErrCode());
    }
}

