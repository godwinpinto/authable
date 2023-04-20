package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ContextConfiguration(classes = {AuthenticationManager.class})
@ExtendWith(SpringExtension.class)
class AuthenticationManagerTest {
    @Autowired
    private AuthenticationManager authenticationManager;

    @MockBean
    Authentication authentication;

    @Test
    void testAuthenticate3() {
        UserDto userDto = UserDto.builder()
                .roles(List.of(Role.ROLE_ADMIN))
                .username("TEST_USER")
                .build();
        doReturn(userDto).when(authentication)
                .getPrincipal();
        doReturn(userDto).when(authentication)
                .getCredentials();

        StepVerifier.create(authenticationManager.authenticate(authentication))
                .assertNext(auth -> assertEquals(userDto.getUsername(), ((UserDto) auth.getPrincipal()).getUsername()));

    }


}

