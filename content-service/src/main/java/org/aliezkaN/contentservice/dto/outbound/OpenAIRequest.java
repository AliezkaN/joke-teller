package org.aliezkaN.contentservice.dto.outbound;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
public class OpenAIRequest {

    private String model;
    private List<OpenAIMessage> messages;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<String> contents;
        private String model;
        private String role;

        public Builder withContent(List<String> contents) {
            this.contents = contents;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public OpenAIRequest build() {
            OpenAIRequest request = new OpenAIRequest();
            request.setModel(model);
            request.setMessages(contents.stream()
                    .map(content -> new OpenAIMessage(role, content))
                    .toList());
            return request;
        }
    }
}
