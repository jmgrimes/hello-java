package com.nerdynarwhal.hello.resource;

import com.nerdynarwhal.hello.api.Saying;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@Path(value = "/hello-world")
@Produces(value = MediaType.APPLICATION_JSON)
public class HelloResource {

    @Getter(value = AccessLevel.PRIVATE) private final AtomicLong counter = new AtomicLong();

    @Getter private final String template;
    @Getter private final String defaultName;

    @GET
    public Saying sayHello(@QueryParam(value = "name") final Optional<String> name) {
        final Long id = getCounter().incrementAndGet();
        final String content = String.format(getTemplate(), name.orElseGet(this::getDefaultName));
        return new Saying(id, content);
    }

}
