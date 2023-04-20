package com.github.godwinpinto.authable.domain.auth.usecase;


import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.commons.exception.NonFatalException;
import com.github.godwinpinto.authable.commons.utils.DateTimeUtils;
import com.github.godwinpinto.authable.domain.auth.dto.Role;
import com.github.godwinpinto.authable.domain.auth.dto.SystemMasterDto;
import com.github.godwinpinto.authable.domain.auth.dto.SystemUserMasterDto;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import com.github.godwinpinto.authable.domain.auth.ports.api.AuthServiceAPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.JWTUtilSPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemMasterSPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemUserMasterSPI;
import com.github.godwinpinto.authable.domain.security.ports.spi.CryptoAlgorithmsSPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Map;


@Service
public class UserService implements AuthServiceAPI {

    SystemMasterSPI systemMasterSPI;

    SystemUserMasterSPI systemUserMasterSPI;

    CryptoAlgorithmsSPI cryptoAlgorithmsSPI;
    JWTUtilSPI jwtUtilspi;


    public UserService(SystemMasterSPI systemMasterSPI,
            SystemUserMasterSPI systemUserMasterSPI,
            CryptoAlgorithmsSPI cryptoAlgorithmsSPI,
            JWTUtilSPI jwtUtilspi) {
        this.systemMasterSPI = systemMasterSPI;
        this.cryptoAlgorithmsSPI = cryptoAlgorithmsSPI;
        this.jwtUtilspi = jwtUtilspi;
        this.systemUserMasterSPI = systemUserMasterSPI;
    }


    @Value("${domain.auth.max-failed-login-attempts}")
    private int maxFailedAttempts;

    public Mono<UserDto> findByUsername(String accessId) {
        return systemUserMasterSPI
                .findById(accessId)
                .switchIfEmpty(Mono.empty())
                .flatMap(systemUserMaster -> {
                    if (!systemUserMaster.getStatus()
                            .equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
                        return Mono.error(new NonFatalException("User access is inactive or disabled"));
                    }

                    UserDto userDto = UserDto.builder()
                            .username(systemUserMaster.getAccessId()
                                    .trim())
                            .roles(Arrays.asList(Role.ROLE_ADMIN))
                            .build();
                    return Mono.just(userDto);
                });
    }

    private Mono<SystemMasterDto> isSystemInActiveOrDisabled(SystemMasterDto system) {
        if (!system.getStatus()
                .equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
            return Mono.error(new NonFatalException("System access is disabled"));
        } else {
            return Mono.just(system);
        }
    }

    private Mono<SystemUserMasterDto> isUserInActiveOrDisabled(SystemUserMasterDto user) {
        if (!user.getStatus()
                .equals(ApplicationConstants.RecordStatus.ACTIVE.getValue())) {
            return Mono.error(new NonFatalException("Your access is inactive or disabled"));
        } else {
            return Mono.just(user);
        }
    }

  /*
    private Mono<SystemUserMasterDto> processInvalid
*/

    private Mono<UserDto> callUpdateSuccessLoginService(SystemUserMasterDto user) {
        return systemUserMasterSPI
                .updateLoginSuccess(user.getAccessId(),
                        DateTimeUtils.getCurrentLocalDateTime())
                .flatMap(x -> {
                    UserDto userDto = UserDto.builder()
                            .username(user.getAccessId()
                                    .trim())
                            .systemId(user.getSystemId()
                                    .trim())
                            .roles(Arrays.asList(Role.ROLE_ADMIN))
                            .build();
                    userDto.setPassword(jwtUtilspi.generateToken(userDto));
                    userDto.setExpiryTime(jwtUtilspi.getExpirationDateFromToken(userDto.getPassword())
                            .getTime());
                    return Mono.just(userDto);
                });
    }

    private Mono<UserDto> callFailedLoginService(SystemUserMasterDto user) {
        short attemptsCount = user.getNoOfAttempts();
        attemptsCount++;
        user.setNoOfAttempts(attemptsCount);
        return systemUserMasterSPI
                .updateInvalidAttempt(user.getAccessId(), user.getNoOfAttempts(),
                        DateTimeUtils.getCurrentLocalDateTime())
                .flatMap(x -> {
                    if (user.getNoOfAttempts() >= maxFailedAttempts) {
                        return systemUserMasterSPI.updateDisable(
                                        user.getAccessId(),
                                        DateTimeUtils.getCurrentLocalDateTime(),
                                        ApplicationConstants.RecordStatus.DISABLED
                                                .getValue())
                                .flatMap(x1 -> {
                                    return Mono.error(new NonFatalException("Account has been locked"));
                                });

                    } else {
                        return Mono.error(new NonFatalException("Invalid Credentials"));
                    }
                });
    }

    public Mono<UserDto> authenticate(String systemId, String userId, String password) {
        return systemMasterSPI.findById(systemId)
                .switchIfEmpty(Mono.error(new NonFatalException("The system is not in active status")))
                .flatMap(this::isSystemInActiveOrDisabled)
                .flatMap(system -> systemUserMasterSPI.findBySystemUser(systemId, userId))
                .switchIfEmpty(Mono.error(new NonFatalException("No User found for system")))
                .flatMap(this::isUserInActiveOrDisabled)
                .flatMap(user -> {
                    if (!user.getUserSecret()
                            .equals(cryptoAlgorithmsSPI.generateHashFromSecret(systemId, userId, password))) {
                        return callFailedLoginService(user);
                    } else {
                        return callUpdateSuccessLoginService(user);
                    }
                });
    }

    @Override
    public String getUsernameFromToken(String token) {
        return jwtUtilspi.getUsernameFromToken(token);
    }

    @Override
    public Boolean validateToken(String token) {
        return jwtUtilspi.validateToken(token);
    }

    @Override
    public Map<String, Object> getClaims(String token) {
        return jwtUtilspi.getClaims(token);
    }
}
