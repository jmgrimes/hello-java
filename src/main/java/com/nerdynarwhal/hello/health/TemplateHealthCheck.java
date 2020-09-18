package com.nerdynarwhal.hello.health;

import com.codahale.metrics.health.HealthCheck;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TemplateHealthCheck extends HealthCheck {

    @Getter private final String template;

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(getTemplate(), "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }

}
