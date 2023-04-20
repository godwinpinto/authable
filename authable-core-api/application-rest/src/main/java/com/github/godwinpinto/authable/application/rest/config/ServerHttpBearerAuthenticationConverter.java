package com.github.godwinpinto.authable.application.rest.config;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ServerHttpBearerAuthenticationConverter
        implements ServerAuthenticationConverter {
    private final String BEARER = "Bearer ";
    private final Predicate<String> matchBearerLength = authValue -> authValue.length() > BEARER.length();
    private final Function<String, Mono<String>> isolateBearerValue =
            authValue -> Mono.justOrEmpty(authValue.substring(BEARER.length()));
    private AuthServiceAPI authServiceAPI;

    public ServerHttpBearerAuthenticationConverter(AuthServiceAPI authServiceAPI) {
        this.authServiceAPI = authServiceAPI;
    }

    @Override
    public Mono<Authentication> convert(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange)
                .flatMap(this::extract)
                .filter(matchBearerLength)
                .flatMap(isolateBearerValue)
                .switchIfEmpty(Mono.empty())
                .flatMap(token -> Mono.just(authServiceAPI.validateToken(token))
                        .filter(valid -> valid)
                        .switchIfEmpty(Mono.empty())
                        .map(valid -> {
                            Map<String, Object> mapClaims = authServiceAPI.getClaims(token);
                            String userId = mapClaims.get("sub")
                                    .toString();
                            List<String> rolesMap = (List<String>) mapClaims.get(ApplicationConstants.JWT_ROLE_KEY);
                            String systemId = (String) mapClaims.get(ApplicationConstants.JWT_SYSTEM_ID_KEY);
                            UserDto user = UserDto.builder()
                                    .username(userId)
                                    .systemId(systemId)
                                    .roles(rolesMap.stream()
                                            .map(Role::valueOf)
                                            .toList())
                                    .build();
                            return
                                    new UsernamePasswordAuthenticationToken(user,
                                            null, user.getAuthorities());
                        }));
    }

    private Mono<String> extract(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(serverWebExchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION));
    }
}