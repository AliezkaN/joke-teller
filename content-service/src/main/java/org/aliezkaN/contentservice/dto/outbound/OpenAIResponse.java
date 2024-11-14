package org.aliezkaN.contentservice.dto.outbound;

import lombok.Data;

import java.util.List;

@Data
public class OpenAIResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private int index;
        private OpenAIMessage message;
    }
}
