package org.aliezkaN.contentservice.service.impl.openai;

import org.aliezkaN.contentservice.dto.outbound.OpenAIMessage;
import org.aliezkaN.contentservice.dto.outbound.OpenAIResponse;
import org.aliezkaN.contentservice.service.JokeContentAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Profile("openai")
@Component
public class OpenAIJokeContentAdapter implements JokeContentAdapter<OpenAIResponse> {

    @Override
    public String adapt(OpenAIResponse content) {
        return content.getChoices()
                .stream()
                .map(OpenAIResponse.Choice::getMessage)
                .filter(Objects::nonNull)
                .map(OpenAIMessage::getContent)
                .filter(Objects::nonNull)
                .findAny()
                .orElse(null);
    }
}