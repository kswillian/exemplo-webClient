package com.kaminski.exemplo.webClient.service;

import com.kaminski.exemplo.webClient.client.RickMortyClient;
import com.kaminski.exemplo.webClient.domain.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {

    private final RickMortyClient client;

    public Mono<Character> consultarPersonagemPorId(Long id){
        return client.findCharacterById(id);
    }

}