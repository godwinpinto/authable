package com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

class SystemUserMasterAdapterTest {
    /**
     * Method under test: {@link SystemUserMasterAdapter#SystemUserMasterAdapter(SystemUserMasterRepository)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SystemUserMasterAdapter.systemUserMasterRepository
        //     SystemUserMasterAdapter.systemUserSpacePadding

        new SystemUserMasterAdapter(mock(SystemUserMasterRepository.class));
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#updateInvalidAttempt(String, short, LocalDateTime)}
     */
    @Test
    void testUpdateInvalidAttempt() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.updateInvalidAttempt(Mockito.<String>any(), anyShort(),
                Mockito.<LocalDateTime>any())).thenReturn(null);
        SystemUserMasterAdapter systemUserMasterAdapter = new SystemUserMasterAdapter(systemUserMasterRepository);
        assertNull(
                systemUserMasterAdapter.updateInvalidAttempt("42", (short) 1, LocalDate.of(1970, 1, 1)
                        .atStartOfDay()));
        verify(systemUserMasterRepository).updateInvalidAttempt(Mockito.<String>any(), anyShort(),
                Mockito.<LocalDateTime>any());
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#updateLoginSuccess(String, LocalDateTime)}
     */
    @Test
    void testUpdateLoginSuccess() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any()))
                .thenReturn(null);
        SystemUserMasterAdapter systemUserMasterAdapter = new SystemUserMasterAdapter(systemUserMasterRepository);
        assertNull(systemUserMasterAdapter.updateLoginSuccess("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay()));
        verify(systemUserMasterRepository).updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any());
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#updateDisable(String, LocalDateTime, String)}
     */
    @Test
    void testUpdateDisable() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        SystemUserMasterAdapter systemUserMasterAdapter = new SystemUserMasterAdapter(systemUserMasterRepository);
        assertNull(systemUserMasterAdapter.updateDisable("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay(), "Status"));
        verify(systemUserMasterRepository).updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#findById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository.findById(Object)" is null
        //       at com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.findById(SystemUserMasterAdapter.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.findById(Mockito.<String>any())).thenReturn(null);
        (new SystemUserMasterAdapter(systemUserMasterRepository)).findById("42");
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#findById(String)}
     */
    @Test
    void testFindById2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<SystemUserMasterEntity> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<SystemUserMasterEntity, Mono<Object>>>any())).thenReturn(null);
        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.findById(Mockito.<String>any())).thenReturn(mono);
        assertNull((new SystemUserMasterAdapter(systemUserMasterRepository)).findById("42"));
        verify(systemUserMasterRepository).findById(Mockito.<String>any());
        verify(mono).flatMap(Mockito.<Function<SystemUserMasterEntity, Mono<Object>>>any());
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#findBySystemUser(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindBySystemUser() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository.findBySystemUser(String, String)" is null
        //       at com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.findBySystemUser(SystemUserMasterAdapter.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.findBySystemUser(Mockito.<String>any(), Mockito.<String>any())).thenReturn(null);
        (new SystemUserMasterAdapter(systemUserMasterRepository)).findBySystemUser("42", "42");
    }

    /**
     * Method under test: {@link SystemUserMasterAdapter#findBySystemUser(String, String)}
     */
    @Test
    void testFindBySystemUser2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<SystemUserMasterEntity> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<SystemUserMasterEntity, Mono<Object>>>any())).thenReturn(null);
        SystemUserMasterRepository systemUserMasterRepository = mock(SystemUserMasterRepository.class);
        when(systemUserMasterRepository.findBySystemUser(Mockito.<String>any(), Mockito.<String>any())).thenReturn(mono);
        assertNull((new SystemUserMasterAdapter(systemUserMasterRepository)).findBySystemUser("42", "42"));
        verify(systemUserMasterRepository).findBySystemUser(Mockito.<String>any(), Mockito.<String>any());
        verify(mono).flatMap(Mockito.<Function<SystemUserMasterEntity, Mono<Object>>>any());
    }
}

