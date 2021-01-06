FROM adoptopenjdk/openjdk11:alpine-jre
ENV OTEL_EXPORTER=logging
ENV OTEL_RESOURCE_ATTRIBUTES="service.name=hello-java"
ADD target/hello-java-*.jar /app/lib/application.jar
ADD target/opentelemetry-javaagent-*.jar /app/lib/agent.jar
ENTRYPOINT [ "java", "-javaagent:/app/lib/agent.jar", "-jar", "/app/lib/application.jar", "server", "/app/conf/application.yaml" ]