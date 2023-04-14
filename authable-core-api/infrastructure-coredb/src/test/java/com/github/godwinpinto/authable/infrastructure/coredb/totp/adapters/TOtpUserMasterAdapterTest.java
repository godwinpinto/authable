package com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.godwinpinto.authable.domain.totp.dto.TOtpUserMasterDto;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.entity.TOtpUserMasterEntity;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.repository.TOtpUserMasterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {TOtpUserMasterAdapter.class})
@ExtendWith(SpringExtension.class)
class TOtpUserMasterAdapterTest {
    @Autowired
    private TOtpUserMasterAdapter tOtpUserMasterAdapter;

    /**
     * Method under test: {@link TOtpUserMasterAdapter#TOtpUserMasterAdapter(TOtpUserMasterRepository)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TOtpUserMasterAdapter.tOtpUserIdPadding
        //     TOtpUserMasterAdapter.tOtpUserMasterRepository

        new TOtpUserMasterAdapter(mock(TOtpUserMasterRepository.class));
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#updateDisable(String, LocalDateTime, String)}
     */
    @Test
    void testUpdateDisable() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        assertNull(tOtpUserMasterAdapter.updateDisable("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay(), "Status"));
        verify(tOtpUserMasterRepository).updateDisable(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#findById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById() {
        // TODO: Complete this test.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String userId = "";

        // Act
        Mono<TOtpUserMasterDto> actualFindByIdResult = this.tOtpUserMasterAdapter.findById(userId);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#updateInvalidAttempt(String, short, LocalDateTime)}
     */
    @Test
    void testUpdateInvalidAttempt() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.updateInvalidAttempt(Mockito.<String>any(), anyShort(),
                Mockito.<LocalDateTime>any())).thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        assertNull(tOtpUserMasterAdapter.updateInvalidAttempt("42", (short) 1, LocalDate.of(1970, 1, 1)
                .atStartOfDay()));
        verify(tOtpUserMasterRepository).updateInvalidAttempt(Mockito.<String>any(), anyShort(),
                Mockito.<LocalDateTime>any());
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#updateLoginSuccess(String, LocalDateTime)}
     */
    @Test
    void testUpdateLoginSuccess() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any()))
                .thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        assertNull(tOtpUserMasterAdapter.updateLoginSuccess("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay()));
        verify(tOtpUserMasterRepository).updateLoginSuccess(Mockito.<String>any(), Mockito.<LocalDateTime>any());
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#removeDisabledStatus(String, LocalDateTime, String)}
     */
    @Test
    void testRemoveDisabledStatus() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any())).thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        assertNull(tOtpUserMasterAdapter.removeDisabledStatus("42", LocalDate.of(1970, 1, 1)
                .atStartOfDay(), "Status"));
        verify(tOtpUserMasterRepository).removeDisabledStatus(Mockito.<String>any(), Mockito.<LocalDateTime>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#updateEntity(TOtpUserMasterDto)}
     */
    @Test
    void testUpdateEntity() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.save(Mockito.<TOtpUserMasterEntity>any())).thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        TOtpUserMasterDto tOtpUserMasterDto = mock(TOtpUserMasterDto.class);
        when(tOtpUserMasterDto.getAccessType()).thenReturn("Access Type");
        when(tOtpUserMasterDto.getCreationId()).thenReturn("42");
        when(tOtpUserMasterDto.getModificationId()).thenReturn("42");
        when(tOtpUserMasterDto.getStatus()).thenReturn("Status");
        when(tOtpUserMasterDto.getSystemId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserSecret()).thenReturn("User Secret");
        when(tOtpUserMasterDto.getCreationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getInvalidAttemptDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLastLoginDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLockedDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getModificationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getNoOfAttempts()).thenReturn((short) 1);
        tOtpUserMasterAdapter.updateEntity(tOtpUserMasterDto);
        verify(tOtpUserMasterRepository).save(Mockito.<TOtpUserMasterEntity>any());
        verify(tOtpUserMasterDto).getAccessType();
        verify(tOtpUserMasterDto).getCreationId();
        verify(tOtpUserMasterDto).getModificationId();
        verify(tOtpUserMasterDto).getStatus();
        verify(tOtpUserMasterDto).getSystemId();
        verify(tOtpUserMasterDto).getUserId();
        verify(tOtpUserMasterDto).getUserSecret();
        verify(tOtpUserMasterDto).getCreationDateTime();
        verify(tOtpUserMasterDto).getInvalidAttemptDateTime();
        verify(tOtpUserMasterDto).getLastLoginDateTime();
        verify(tOtpUserMasterDto).getLockedDateTime();
        verify(tOtpUserMasterDto).getModificationDateTime();
        verify(tOtpUserMasterDto).getNoOfAttempts();
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#updateEntity(TOtpUserMasterDto)}
     */
    @Test
    void testUpdateEntity2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<TOtpUserMasterEntity> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<TOtpUserMasterEntity, Mono<Object>>>any())).thenReturn(null);
        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.save(Mockito.<TOtpUserMasterEntity>any())).thenReturn(mono);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        TOtpUserMasterDto tOtpUserMasterDto = mock(TOtpUserMasterDto.class);
        when(tOtpUserMasterDto.getAccessType()).thenReturn("Access Type");
        when(tOtpUserMasterDto.getCreationId()).thenReturn("42");
        when(tOtpUserMasterDto.getModificationId()).thenReturn("42");
        when(tOtpUserMasterDto.getStatus()).thenReturn("Status");
        when(tOtpUserMasterDto.getSystemId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserSecret()).thenReturn("User Secret");
        when(tOtpUserMasterDto.getCreationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getInvalidAttemptDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLastLoginDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLockedDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getModificationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getNoOfAttempts()).thenReturn((short) 1);
        tOtpUserMasterAdapter.updateEntity(tOtpUserMasterDto);
        verify(tOtpUserMasterRepository).save(Mockito.<TOtpUserMasterEntity>any());
        verify(mono).flatMap(Mockito.<Function<TOtpUserMasterEntity, Mono<Object>>>any());
        verify(tOtpUserMasterDto).getAccessType();
        verify(tOtpUserMasterDto).getCreationId();
        verify(tOtpUserMasterDto).getModificationId();
        verify(tOtpUserMasterDto).getStatus();
        verify(tOtpUserMasterDto).getSystemId();
        verify(tOtpUserMasterDto).getUserId();
        verify(tOtpUserMasterDto).getUserSecret();
        verify(tOtpUserMasterDto).getCreationDateTime();
        verify(tOtpUserMasterDto).getInvalidAttemptDateTime();
        verify(tOtpUserMasterDto).getLastLoginDateTime();
        verify(tOtpUserMasterDto).getLockedDateTime();
        verify(tOtpUserMasterDto).getModificationDateTime();
        verify(tOtpUserMasterDto).getNoOfAttempts();
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#createEntity(TOtpUserMasterDto)}
     */
    @Test
    void testCreateEntity() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.save(Mockito.<TOtpUserMasterEntity>any())).thenReturn(null);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        TOtpUserMasterDto tOtpUserMasterDto = mock(TOtpUserMasterDto.class);
        when(tOtpUserMasterDto.getAccessType()).thenReturn("Access Type");
        when(tOtpUserMasterDto.getCreationId()).thenReturn("42");
        when(tOtpUserMasterDto.getModificationId()).thenReturn("42");
        when(tOtpUserMasterDto.getStatus()).thenReturn("Status");
        when(tOtpUserMasterDto.getSystemId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserSecret()).thenReturn("User Secret");
        when(tOtpUserMasterDto.getCreationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getInvalidAttemptDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLastLoginDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLockedDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getModificationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getNoOfAttempts()).thenReturn((short) 1);
        tOtpUserMasterAdapter.createEntity(tOtpUserMasterDto);
        verify(tOtpUserMasterRepository).save(Mockito.<TOtpUserMasterEntity>any());
        verify(tOtpUserMasterDto).getAccessType();
        verify(tOtpUserMasterDto).getCreationId();
        verify(tOtpUserMasterDto).getModificationId();
        verify(tOtpUserMasterDto).getStatus();
        verify(tOtpUserMasterDto).getSystemId();
        verify(tOtpUserMasterDto).getUserId();
        verify(tOtpUserMasterDto).getUserSecret();
        verify(tOtpUserMasterDto).getCreationDateTime();
        verify(tOtpUserMasterDto).getInvalidAttemptDateTime();
        verify(tOtpUserMasterDto).getLastLoginDateTime();
        verify(tOtpUserMasterDto).getLockedDateTime();
        verify(tOtpUserMasterDto).getModificationDateTime();
        verify(tOtpUserMasterDto).getNoOfAttempts();
    }

    /**
     * Method under test: {@link TOtpUserMasterAdapter#createEntity(TOtpUserMasterDto)}
     */
    @Test
    void testCreateEntity2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R033 Missing Spring properties.
        //   Failed to create Spring context due to unresolvable @Value
        //   properties: Spring @Value annotation can't be resolved: private int com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter.tOtpUserIdPadding
        //   Please check that at least one of the property files is provided
        //   and contains required variables:
        //   - application-test.properties (file missing)
        //   See https://diff.blue/R033 to resolve this issue.

        Mono<TOtpUserMasterEntity> mono = mock(Mono.class);
        when(mono.log()).thenReturn(null);
        TOtpUserMasterRepository tOtpUserMasterRepository = mock(TOtpUserMasterRepository.class);
        when(tOtpUserMasterRepository.save(Mockito.<TOtpUserMasterEntity>any())).thenReturn(mono);
        TOtpUserMasterAdapter tOtpUserMasterAdapter = new TOtpUserMasterAdapter(tOtpUserMasterRepository);
        TOtpUserMasterDto tOtpUserMasterDto = mock(TOtpUserMasterDto.class);
        when(tOtpUserMasterDto.getAccessType()).thenReturn("Access Type");
        when(tOtpUserMasterDto.getCreationId()).thenReturn("42");
        when(tOtpUserMasterDto.getModificationId()).thenReturn("42");
        when(tOtpUserMasterDto.getStatus()).thenReturn("Status");
        when(tOtpUserMasterDto.getSystemId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserId()).thenReturn("42");
        when(tOtpUserMasterDto.getUserSecret()).thenReturn("User Secret");
        when(tOtpUserMasterDto.getCreationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getInvalidAttemptDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLastLoginDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getLockedDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getModificationDateTime()).thenReturn(LocalDate.of(1970, 1, 1)
                .atStartOfDay());
        when(tOtpUserMasterDto.getNoOfAttempts()).thenReturn((short) 1);
        tOtpUserMasterAdapter.createEntity(tOtpUserMasterDto);
        verify(tOtpUserMasterRepository).save(Mockito.<TOtpUserMasterEntity>any());
        verify(mono).log();
        verify(tOtpUserMasterDto).getAccessType();
        verify(tOtpUserMasterDto).getCreationId();
        verify(tOtpUserMasterDto).getModificationId();
        verify(tOtpUserMasterDto).getStatus();
        verify(tOtpUserMasterDto).getSystemId();
        verify(tOtpUserMasterDto).getUserId();
        verify(tOtpUserMasterDto).getUserSecret();
        verify(tOtpUserMasterDto).getCreationDateTime();
        verify(tOtpUserMasterDto).getInvalidAttemptDateTime();
        verify(tOtpUserMasterDto).getLastLoginDateTime();
        verify(tOtpUserMasterDto).getLockedDateTime();
        verify(tOtpUserMasterDto).getModificationDateTime();
        verify(tOtpUserMasterDto).getNoOfAttempts();
    }
}

