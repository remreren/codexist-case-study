package dev.remreren.configuration;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.places")
public class GooglePlacesConfiguration {

    private String key;

    private Long radius;

}
