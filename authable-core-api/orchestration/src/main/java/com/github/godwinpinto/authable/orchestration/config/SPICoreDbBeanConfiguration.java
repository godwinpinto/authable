package com.github.godwinpinto.authable.orchestration.config;

import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemMasterSPI;
import com.github.godwinpinto.authable.domain.auth.ports.spi.SystemUserMasterSPI;
import com.github.godwinpinto.authable.domain.totp.ports.spi.TOtpUserMasterSPI;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemMasterAdapter;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.adapters.SystemUserMasterAdapter;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.auth.repository.SystemUserMasterRepository;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.adapters.TOtpUserMasterAdapter;
import com.github.godwinpinto.authable.infrastructure.coredb.totp.repository.TOtpUserMasterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SPICoreDbBeanConfiguration {

    private SystemMasterRepository systemMasterRepository;

    private SystemUserMasterRepository systemUserMasterRepository;

    private TOtpUserMasterRepository tOtpUserMasterRepository;


    public SPICoreDbBeanConfiguration(
            SystemUserMasterRepository systemUserMasterRepository,
            SystemMasterRepository systemMasterRepository,
            TOtpUserMasterRepository tOtpUserMasterRepository
    ) {
        this.systemMasterRepository = systemMasterRepository;
        this.systemUserMasterRepository = systemUserMasterRepository;
        this.tOtpUserMasterRepository = tOtpUserMasterRepository;
    }


    @Bean
    public SystemMasterSPI systemMasterSPI() {
        return new SystemMasterAdapter(systemMasterRepository);
    }

    @Bean
    public SystemUserMasterSPI systemUserMasterSPI() {
        return new SystemUserMasterAdapter(systemUserMasterRepository);
    }

    @Bean
    public TOtpUserMasterSPI tOtpUserMasterSPI() {
        return new TOtpUserMasterAdapter(tOtpUserMasterRepository);
    }


}
