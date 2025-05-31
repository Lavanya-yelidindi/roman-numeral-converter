# Stage 1: Build the application
FROM eclipse-temurin:17-jdk as build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2: Package the application
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built jar from Maven build
COPY --from=build /app/target/roman-numeral-converter-1.0.0.jar app.jar

# Expose the port your app runs on (default 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
