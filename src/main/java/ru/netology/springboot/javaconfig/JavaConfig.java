package ru.netology.springboot.javaconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springboot.profile.DevProfile;
import ru.netology.springboot.profile.ProductionProfile;
import ru.netology.springboot.profile.SystemProfile;

@Configuration
public class JavaConfig {

    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true", matchIfMissing = true)
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
