package org.aliezkaN.contentservice.controller;

import lombok.RequiredArgsConstructor;
import org.aliezkaN.contentservice.service.JokeContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joke-teller/content-service/api")
@RequiredArgsConstructor
public class ContentController {

    private final JokeContentService service;

    @GetMapping("/tell-joke")
    String getContent() {
        return service.getJoke();
    }
}
