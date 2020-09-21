FROM adoptopenjdk/openjdk11:alpine-slim
ADD target/hello-java-*.jar /app/lib/application.jar
ENTRYPOINT [ "java", "-jar", "/app/lib/application.jar", "server", "/app/conf/application.yaml" ]