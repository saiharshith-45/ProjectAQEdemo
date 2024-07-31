# Use an official Java runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/DemoAQEProject-0.0.1-SNAPSHOT.jar DemoAQEProject.jar

# Expose the port the app runs on
EXPOSE 9090

# Run the JAR file
ENTRYPOINT ["java", "-jar", "DemoAQEProject.jar"]
