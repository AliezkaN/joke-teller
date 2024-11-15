package org.aliezkaN.contentservice.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Getter
@Setter
@ConfigurationProperties(prefix = "openai")
public class OpenAIProperties {
    private String secretKey;
    private URI uri;
    private String model;
    private String role;
}


