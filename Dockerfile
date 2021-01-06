FROM adoptopenjdk/openjdk11:alpine-jre
ENV OTEL_EXPORTER=logging
ENV OTEL_RESOURCE_ATTRIBUTES="service.name=hello-java"
ADD target/hello-java-*.jar /app/lib/hello-java-application.jar
ADD target/opentelemetry-javaagent-*.jar /app/lib/hello-java-agent.jar
ENTRYPOINT [ "java", "-javaagent:/app/lib/hello-java-agent.jar", "-jar", "/app/lib/hello-java-application.jar", "server", "/app/conf/application.yaml" ]