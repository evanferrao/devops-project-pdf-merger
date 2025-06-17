FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the jar file
COPY target/pdf-merger-1.0.0.jar pdf-merger-1.0.0.jar

# Expose the port the app runs on
EXPOSE 1234

# Run the jar
ENTRYPOINT ["java", "-jar", "pdf-merger-1.0.0.jar", "--server.port=1234"]
