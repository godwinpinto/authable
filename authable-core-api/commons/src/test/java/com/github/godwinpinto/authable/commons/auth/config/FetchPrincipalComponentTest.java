package com.github.godwinpinto.authable.commons.auth.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@TestConfiguration
@Import({FetchPrincipalComponent.class})
class FetchPrincipalComponentTest {

  @Autowired FetchPrincipalComponent fetchPrincipalComponent;

  @Test
  @WithMockCustomUser(username = "GODWIN")
  void fetchUserDetailsTest() {
    UserDto userDto =
        UserDto.builder()
            .username("GODWIN")
            .password("123")
            .roles(List.of(Role.ROLE_ADMIN))
            .build();

    StepVerifier.create(fetchPrincipalComponent.getAuthDetails())
        .assertNext(
            user -> {
              assertThat(user.toString()).hasToString(userDto.toString());
            })
        .expectComplete()
        .verify();
  }

  @Test
  void NoUserSetTest() {
    UserDto userDto =
        UserDto.builder()
            .username("GODWIN")
            .password("123")
            .roles(List.of(Role.ROLE_ADMIN))
            .build();

    StepVerifier.create(fetchPrincipalComponent.getAuthDetails())
        .expectError(AuthorizationServiceException.class)
        .verify();
  }
}
