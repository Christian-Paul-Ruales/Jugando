FROM gradle:8.7-jdk21-alpine AS build

WORKDIR /app

COPY gradle gradle
COPY gradlew .
COPY gradlew.bat .
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x gradlew

COPY src src

RUN ./gradlew clean build -x test --no-daemon

RUN ./gradlew test --no-daemon

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8001/actuator/health || exit 1

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

