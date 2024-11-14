package org.aliezkaN.contentservice.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractJokeContentService <T> implements JokeContentService {

    private final JokeContentProvider<T> provider;
    private final JokeContentAdapter<T> adapter;

    @Override
    public String getJoke() {
        T jokeContent = provider.getJokeContent();
        return adapter.adapt(jokeContent);
    }
}
