package org.aliezkaN.contentservice.service.impl.openai;

import org.aliezkaN.contentservice.dto.outbound.OpenAIResponse;
import org.aliezkaN.contentservice.service.AbstractJokeContentService;
import org.aliezkaN.contentservice.service.JokeContentAdapter;
import org.aliezkaN.contentservice.service.JokeContentProvider;

public class OpenAIJokeContentService extends AbstractJokeContentService<OpenAIResponse> {
    public OpenAIJokeContentService(JokeContentProvider<OpenAIResponse> provider,
                                    JokeContentAdapter<OpenAIResponse> adapter) {
        super(provider, adapter);
    }
}
