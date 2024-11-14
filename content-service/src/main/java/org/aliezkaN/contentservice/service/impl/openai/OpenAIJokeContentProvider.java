package org.aliezkaN.contentservice.service.impl.openai;

import lombok.RequiredArgsConstructor;
import org.aliezkaN.contentservice.configuration.properties.OpenAIProperties;
import org.aliezkaN.contentservice.dto.outbound.OpenAIRequest;
import org.aliezkaN.contentservice.dto.outbound.OpenAIResponse;
import org.aliezkaN.contentservice.service.JokeContentProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Collections;

@Profile("openai")
@Component
@RequiredArgsConstructor
public class OpenAIJokeContentProvider implements JokeContentProvider<OpenAIResponse> {

    private final OpenAIProperties properties;
    private final RestClient restClient;

    @Override
    public OpenAIResponse getJokeContent() {
        return restClient.post()
                .uri(properties.getUri())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(properties.getSecretKey()))
                .body(OpenAIRequest.builder()
                        .withModel(properties.getModel())
                        .withRole(properties.getRole())
                        .withContent(Collections.singletonList(
                                "Tell me a joke"
                        ))
                        .build())
                .retrieve()
                .body(OpenAIResponse.class);
    }
}
