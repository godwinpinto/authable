package com.github.godwinpinto.authable.domain.auth.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

class UserDtoTest {


    UserDto userDto;
    UserDto userDto1;

    UserDto userDto3;

    @Test
    void testFields() {
        userDto = new UserDto();

        String password = "PASSWORD";
        userDto.setPassword(password);

        boolean enabled = true;
        userDto.setEnabled(enabled);

        List<Role> roles = List.of(Role.ROLE_USER, Role.ROLE_ADMIN);
        userDto.setRoles(roles);

        String systemId = "SYSTEMID";
        userDto.setSystemId(systemId);

        String username = "USERNAME";
        userDto.setUsername(username);

        long expiryTime = 1l;
        userDto.setExpiryTime(expiryTime);

        String jwtCode = "JWT";
        userDto.setJwtCode(jwtCode);

        userDto1 = UserDto.builder()
                .password(password)
                .roles(roles)
                .username(username)
                .systemId(systemId)
                .enabled(enabled)
                .jwtCode(jwtCode)
                .expiryTime(expiryTime)
                .build();


        UserDto userDto2 = new UserDto();

        assertEquals(
                userDto1.toString(),
                userDto.toString());

        assertEquals(userDto.isAccountNonExpired(), false);
        assertEquals(userDto.isAccountNonLocked(), false);
        assertEquals(userDto.isCredentialsNonExpired(), false);
        assertEquals(userDto.isEnabled(), true);

        assertNotNull("Error null authorities", userDto.getAuthorities());

        assertNotNull("Not null", userDto2);

        userDto3 = new UserDto(username, systemId, jwtCode, password, expiryTime, false, roles);

        int expectedHashCodeResult = userDto3.hashCode();
        assertEquals(expectedHashCodeResult, userDto3.hashCode());

        int expectedHashCodeResultNotSame = userDto1.hashCode();
        assertNotEquals(expectedHashCodeResultNotSame, userDto2.hashCode());


    }


}

