FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Install Maven
# RUN apt-get update && \
#     apt-get install -y maven && \
#     apt-get clean && \
#     mvn --version
# Copy Maven files separately to leverage Docker cache

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set the entrypoint to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]