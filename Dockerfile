FROM openjdk:24-jdk
ARG JAR_FILE=build/libs/FlashLyrics-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} flashlyrics.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "flashlyrics.jar"]