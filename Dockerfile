FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw ./
COPY pom.xml ./
COPY src ./src
RUN sed -i -e 's/\r$//' ./mvnw
RUN chmod +x mvnw
RUN ./mvnw clean package -P dev

ENTRYPOINT ["java","-jar","./target/check-online-1.0.0-SNAPSHOT.jar"]
#ENTRYPOINT ["/bin/bash"]