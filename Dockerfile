# Use a lightweight JRE base image for Java 21
FROM eclipse-temurin:21-jre-jammy

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR (built with `mvn clean package`)
COPY target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use a slim Temurin runtime for Java 21
# FROM eclipse-temurin:21-jre-jammy

# # --- Metadata / build-time args (optional) ---
# ARG APP_JAR="lookice-services-1.0-SNAPSHOT.jar"
# LABEL maintainer="you@example.com"
# LABEL org.opencontainers.image.source="https://your-repo-url"

# # --- Create non-root user and app dir ---
# RUN useradd --create-home --shell /bin/false spring \
#  && mkdir -p /app \
#  && chown spring:spring /app

# WORKDIR /app
# RUN test -d "/app" && echo "Directory exists." || echo "Directory does NOT exist."

# # --- Copy the application JAR (make sure you build it locally before docker build) ---
# # e.g. mvn -DskipTests package -> target/myapp.jar
# COPY ./target/${APP_JAR} .
# RUN chown spring:spring /app/${APP_JAR}

# # --- Switch to non-root user ---
# USER spring

# # --- Expose the port your Spring Boot app uses ---
# EXPOSE 8080

# # --- Environment / JVM tuning ---
# # You can override JAVA_OPTS at runtime (task definition / environment variables)
# ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp -Djava.security.egd=file:/dev/urandom"

# # if you need to run locally
# # ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp -Djava.security.egd=file:/dev/urandom -Dspring.profiles.active=local"

# # Entrypoint using exec form so signals are forwarded correctly
# ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/${APP_JAR}"]

# # --- Simple healthcheck (can be overridden by ECS health checks) ---
# HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
#   CMD wget -qO- --tries=1 --timeout=2 http://127.0.0.1:8080/actuator/health || exit 1
