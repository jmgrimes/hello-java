package com.nerdynarwhal.hello.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Saying {

    @JsonProperty
    @Getter private Long id;

    @JsonProperty
    @Getter private String content;

}
