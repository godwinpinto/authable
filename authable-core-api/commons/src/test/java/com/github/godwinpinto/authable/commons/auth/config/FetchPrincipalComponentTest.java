package com.github.godwinpinto.authable.commons.auth.config;

import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {FetchPrincipalComponent.class})
@ExtendWith(SpringExtension.class)
class FetchPrincipalComponentTest {
    @Autowired
    private FetchPrincipalComponent fetchPrincipalComponent;

    /**
     * Method under test: {@link FetchPrincipalComponent#getAuthDetails()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAuthDetails() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NoSuchMethodError: 'reactor.core.publisher.Mono reactor.core.publisher.Mono.subscriberContext()'
        //       at com.github.godwinpinto.authable.commons.auth.config.FetchPrincipalComponent.getAuthDetails(FetchPrincipalComponent.java:13)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        // TODO: Populate arranged inputs
        Mono<UserDto> actualAuthDetails = this.fetchPrincipalComponent.getAuthDetails();

        // Assert
        // TODO: Add assertions on result
    }
}

