package com.github.godwinpinto.authable.application.rest.auth.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Validator;

@ExtendWith(SpringExtension.class)
@Import({SystemHandler.class,
        Validator.class})
class SystemRoutesConfigTest {

    @Autowired
    private SystemHandler systemHandler;

    @Autowired
    private SystemRoutesConfig systemRoutesConfig;

    /**
     * Method under test: {@link SystemRoutesConfig#reissueToken(SystemHandler)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReissueToken() {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.LibraryLinkageException: java.lang.NoClassDefFoundError: Could not initialize class org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTypeExcludeFilter
        //       at java.util.Optional.map(Optional.java:260)
        //   java.lang.NoClassDefFoundError: Could not initialize class org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTypeExcludeFilter
        //       at java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        systemRoutesConfig.reissueToken(systemHandler);
    }
}

