package com.kaminski.exemplo.webClient.controller;

import com.kaminski.exemplo.webClient.domain.Character;
import com.kaminski.exemplo.webClient.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/personagem")
@RequiredArgsConstructor
public class WebClientController {

    private final WebClientService service;

    @GetMapping("/{id}")
    public Mono<Character> consultarPersonagemPorId(@PathVariable Long id) {
        return service.consultarPersonagemPorId(id);
    }

}