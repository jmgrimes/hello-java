FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/hello-java-*.jar /app/lib/application.jar
ADD target/opentelemetry-javaagent-*.jar /app/lib/agent.jar
ENTRYPOINT [ "java", "-javaagent:/app/lib/agent.jar", "-jar", "/app/lib/application.jar", "server", "/app/conf/application.yaml" ]