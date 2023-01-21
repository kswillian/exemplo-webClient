package com.kaminski.exemplo.webClient.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.kaminski.exemplo.webClient.domain.Character;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@AllArgsConstructor
public class RickMortyClient {

    private final WebClient webClient;

    public Mono<Character> findCharacterById(Long id) {

        var characterMono = webClient
                .get()
                .uri("/character/".concat(id.toString()))
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Favor informar um ID válido.")))
                .bodyToMono(Character.class);

        return characterMono;
    }

}