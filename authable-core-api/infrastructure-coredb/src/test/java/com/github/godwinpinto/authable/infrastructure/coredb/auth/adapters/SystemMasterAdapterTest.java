package com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.infrastructure.coredb.auth.entity.SystemMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

class SystemMasterAdapterTest {
    /**
     * Method under test: {@link SystemMasterAdapter#SystemMasterAdapter(SystemMasterRepository)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SystemMasterAdapter.systemMasterRepository
        //     SystemMasterAdapter.systemUserSpacePadding

        new SystemMasterAdapter(mock(SystemMasterRepository.class));
    }

    /**
     * Method under test: {@link SystemMasterAdapter#updateDisable(String, LocalDateTime, String)}
     */
    @Test
    void testUpdateDisable() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        SystemMasterRepository systemMasterRepository = mock(SystemMasterRepository.class);
        when(systemMasterRepository.updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        SystemMasterAdapter systemMasterAdapter = new SystemMasterAdapter(systemMasterRepository);
        assertNull(systemMasterAdapter.updateDisable("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay(), "Status"));
        verify(systemMasterRepository).updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link SystemMasterAdapter#findById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because the return value of "com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository.findById(Object)" is null
        //       at com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemMasterAdapter.findById(SystemMasterAdapter.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        SystemMasterRepository systemMasterRepository = mock(SystemMasterRepository.class);
        when(systemMasterRepository.findById(Mockito.<String>any())).thenReturn(null);
        (new SystemMasterAdapter(systemMasterRepository)).findById("42");
    }

    /**
     * Method under test: {@link SystemMasterAdapter#findById(String)}
     */
    @Test
    void testFindById2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemMasterAdapter.systemUserSpacePadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<SystemMasterEntity> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<SystemMasterEntity, Mono<Object>>>any())).thenReturn(null);
        SystemMasterRepository systemMasterRepository = mock(SystemMasterRepository.class);
        when(systemMasterRepository.findById(Mockito.<String>any())).thenReturn(mono);
        assertNull((new SystemMasterAdapter(systemMasterRepository)).findById("42"));
        verify(systemMasterRepository).findById(Mockito.<String>any());
        verify(mono).flatMap(Mockito.<Function<SystemMasterEntity, Mono<Object>>>any());
    }
}

