# Use Java 17 JDK
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the project (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose the port the app will run on
EXPOSE 8080

# Start the Spring Boot app
CMD ["java", "-jar", "target/mkshoes-Backend.jar"]