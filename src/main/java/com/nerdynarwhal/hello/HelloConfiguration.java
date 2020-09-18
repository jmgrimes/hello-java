package com.nerdynarwhal.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class HelloConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    @Getter @Setter private String template;

    @NotEmpty
    @JsonProperty
    @Getter @Setter private String defaultName;

}