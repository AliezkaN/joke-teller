package org.aliezkaN.contentservice.configuration;

import org.aliezkaN.contentservice.configuration.properties.OpenAIProperties;
import org.aliezkaN.contentservice.service.impl.openai.OpenAIJokeContentAdapter;
import org.aliezkaN.contentservice.service.impl.openai.OpenAIJokeContentProvider;
import org.aliezkaN.contentservice.service.impl.openai.OpenAIJokeContentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@Profile("openai")
@Configuration
@EnableConfigurationProperties(OpenAIProperties.class)
@ConditionalOnClass(value = {
        RestClient.class,
        OpenAIProperties.class,
        OpenAIJokeContentProvider.class,
        OpenAIJokeContentAdapter.class,
        OpenAIJokeContentService.class
})
public class OpenAIConfiguration {

    @Bean
    @ConditionalOnBean(value = {OpenAIProperties.class, RestClient.class})
    public OpenAIJokeContentProvider openAIJokeContentProvider(OpenAIProperties properties,
                                                               RestClient restClient) {
        return new OpenAIJokeContentProvider(properties, restClient);
    }

    @Bean
    public OpenAIJokeContentAdapter openAIJokeContentAdapter() {
        return new OpenAIJokeContentAdapter();
    }

    @Bean
    @ConditionalOnBean(value = {OpenAIJokeContentProvider.class, OpenAIJokeContentAdapter.class})
    public OpenAIJokeContentService openAIJokeContentService(OpenAIJokeContentProvider provider,
                                                             OpenAIJokeContentAdapter adapter) {
        return new OpenAIJokeContentService(provider, adapter);
    }

}
