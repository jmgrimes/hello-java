FROM adoptopenjdk/openjdk11:alpine-slim
ADD target/hello-java-*.jar /app/application.jar
ENTRYPOINT [ "java", "-jar", "/app/application.jar", "server", "/app/application.yaml" ]