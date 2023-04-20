package com.github.godwinpinto.authable.application;

import com.github.godwinpinto.authable.application.rest.config.AuthenticationManager;
import com.github.godwinpinto.authable.application.rest.config.SecurityConfig;
import com.github.godwinpinto.authable.application.rest.config.SecurityContextRepository;
import com.github.godwinpinto.authable.application.rest.totp.controller.*;
import com.github.godwinpinto.authable.application.rest.totp.json.GenericRequest;
import com.github.godwinpinto.authable.application.rest.totp.json.StatusResponse;
import com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.auth.usecase.UserService;
import com.github.godwinpinto.authable.domain.totp.ports.api.TOtpUserServiceAPI;
import com.github.godwinpinto.authable.infrastructure.crypto.service.JWTUtilService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest
@Import({TOtpStatusHandler.class,
        TOtpRoutesConfig.class,
        SecurityConfig.class,
        AuthenticationManager.class,
        SecurityContextRepository.class,
        JWTUtilService.class
})

@ContextConfiguration(classes = AuthableApplicationTest.class)
public class TOtpStatusHandlerTest {

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private TOtpStatusHandler tOtpStatusHandler;

    @MockBean
    TOtpUserServiceAPI tOtpUserServiceAPI;

    @MockBean
    FetchPrincipalComponent fetchPrincipalComponent;

    @MockBean
    TOtpVerifyHandler tOtpVerifyHandler;

    @MockBean
    TOtpUnSubscribeHandler tOtpUnSubscribeHandler;

    @MockBean
    TOtpUnBlockHandler tOtpUnBlockHandler;

    @MockBean
    TOtpSubscribeHandler tOtpSubscribeHandler;

    @MockBean
    TOtpGenerateQrHandler tOtpGenerateQrHandler;


    @Autowired
    Validator validator;

    @Autowired
    JWTUtilService jwtUtilService;

    @MockBean
    JWTUtilSPI jwtUtilSPI;

    @MockBean
    UserService userService;

    @Test
    public void tOtpStatus_UnAuthorizedUser_Test() {

        UserDto userDto = UserDto.builder()
                .username("CARDS")
                .password("JWTTOKEN")
                .roles(List.of(Role.ROLE_ADMIN))
                .expiryTime(0)
                .build();
//
//        when(userService.findByUsername(anyString()).then(userDto);

        when(fetchPrincipalComponent.getAuthDetails()).thenReturn(Mono.just(userDto));
        when(tOtpUserServiceAPI
                .getUserStatus(anyString(), anyString())).thenReturn(Mono.empty());

        GenericRequest genericRequest = GenericRequest.builder()
                .userId("TEST_USER")
                .build();

        webClient
                .post()
                .uri("/totp/status")
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(genericRequest)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .consumeWith(System.out::println)
                /*.jsonPath("statusDescription")
                .isEqualTo("No active subscription")
                .jsonPath("$.statusCode")
                .isEqualTo("300")*/
        ;
    }

    @Test
    public void tOtpStatus_AuthorizedUser_Test() {

/*
        IssueTokenRequest issueTokenRequest = IssueTokenRequest.builder().systemId("CARDS").systemSecret("1234").build();

        UserDto userDto = UserDto.builder().username("CARDS").password("JWTTOKEN").roles(List.of(Role.ROLE_ADMIN)).expiryTime(0).build();

        when(authServiceAPI.authenticate(issueTokenRequest.getSystemId(), issueTokenRequest.getSystemSecret())).thenReturn(Mono.just(userDto));
*/

        //when(systemMasterSPI.findById(systemId))

        UserDto userDto = UserDto.builder()
                .username("0382b9de-feca-4947-ba72-c75cd52e51f0")
                .roles(List.of(Role.ROLE_ADMIN))
                .expiryTime(0)
                .build();
        String token = jwtUtilService.generateToken(userDto);
        when(jwtUtilSPI.validateToken(token)).thenReturn(true);

        webClient
                .post()
                .uri("/totp/status")
                .headers(h -> h.setBearerAuth(token))
                .accept(MediaType.APPLICATION_JSON)
                //.bodyValue(issueTokenRequest)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(StatusResponse.class)
        ;
    }


}
