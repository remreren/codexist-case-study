package dev.remreren.configuration;

import feign.Logger;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "codexist.places")
public class GooglePlacesConfiguration {

    private String key;

    @Bean
    public Logger.Level level() {

        return Logger.Level.FULL;

    }

}
