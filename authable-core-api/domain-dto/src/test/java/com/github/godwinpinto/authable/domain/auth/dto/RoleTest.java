package com.github.godwinpinto.authable.domain.auth.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testVerifyEnums() {
        assertEquals(Role.ROLE_USER.toString(), "ROLE_USER");
        assertEquals(Role.ROLE_ADMIN.toString(), "ROLE_ADMIN");
    }
}
