package com.kaminski.exemplo.webClient.domain;

import lombok.Data;

@Data
public class Character {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;

}
