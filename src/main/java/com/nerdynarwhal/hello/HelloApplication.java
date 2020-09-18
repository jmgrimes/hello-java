package com.nerdynarwhal.hello;

import com.nerdynarwhal.hello.health.TemplateHealthCheck;
import com.nerdynarwhal.hello.resource.HelloResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloApplication extends Application<HelloConfiguration> {

    public static void main(final String... arguments) throws Exception {
        new HelloApplication().run(arguments);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(final HelloConfiguration configuration, final Environment environment) {
        final HelloResource resource = new HelloResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
