package com.github.godwinpinto.authable.commons;

import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Configuration
@Import({FetchPrincipalComponent.class})
public class PrincipalTest {


    @Autowired
    FetchPrincipalComponent fetchPrincipalComponent;

    @Test
    @WithMockCustomUser(username = "GODWIN")
    public void fetchUserDetailsTest() {
        UserDto userDto = UserDto.builder()
                .username("GODWIN")
                .password("123")
                .roles(List.of(Role.ROLE_ADMIN))
                .build();

        StepVerifier.create(fetchPrincipalComponent.getAuthDetails())
                .assertNext(user -> {
                    assertThat(user.toString()).isEqualTo(userDto.toString());
                })
                .expectComplete()
                .verify();
    }

    @Test
    public void NoUserSetTest() {
        UserDto userDto = UserDto.builder()
                .username("GODWIN")
                .password("123")
                .roles(List.of(Role.ROLE_ADMIN))
                .build();

        StepVerifier.create(fetchPrincipalComponent.getAuthDetails())
                .expectError(AuthorizationServiceException.class)
                .verify();
    }

    /*@BeforeAll
    public static void setUp() throws Exception {
        UserDto userDto = UserDto.builder()
                .username("GODWIN")
                .build();
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(userDto);
        TestSecurityContextHolder.setAuthentication(authentication);
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

    }*/


    /*@MockBean
    SecurityContext securityContext;*/

   /* @MockBean
    AuthenticationManager authenticationManager;


    Mono<String> findMessageByUsername(String username) {
        return Mono.just("Hi " + username);
    }

    @Test
    @WithMockUser(username = "GODWIN")
    public void validUser() {


        String userName = "GODWIN";


        UserDto userDto = UserDto.builder()
                .username("GODWIN")
                .build();

        Authentication authentication = new TestingAuthenticationToken(userDto, "password", "ROLE_USER");

        when(authenticationManager.authenticate(authentication)
                .then(Mono.just(authentication)));

        Mono<UserDto> messageByUsername = ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .flatMap(o -> {
                    return fetchPrincipalComponent.getAuthDetails();
                })
                // In a WebFlux application the `subscriberContext` is automatically setup using `ReactorContextWebFilter`
                .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication));


        StepVerifier.create(messageByUsername)
                .assertNext(user -> user.getUsername()
                        .equals("GODWIN"))
                .verifyComplete();

        *//*authentication = new UsernamePasswordAuthenticationToken("GODWIN",
                "", null);*//*

     *//*  authentication = new UsernamePasswordAuthenticationToken(userDto,
                "", null);

        // when(authentication.getPrincipal()).thenReturn(userDto);


        TestSecurityContextHolder.setAuthentication(authentication);
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        ReactiveSecurityContextHolder.withAuthentication(authentication);
        *//**//*mockStatic(SecurityContextHolder.getContext()
                .getAuthentication()
                ).thenReturn(userDto);*//**//*


        StepVerifier.create(fetchPrincipalComponent.getAuthDetails())
                .assertNext(user -> user.getUsername()
                        .equals("GODWIN"))
                .expectComplete()
                .verify();*//*


    }*/

}
