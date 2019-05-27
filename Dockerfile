FROM openjdk:11-jdk-stretch
ADD /target/userservice-0.0.1-SNAPSHOT.jar /src/app/muzix/userservice-0.0.1-SNAPSHOT.jar
WORKDIR /src/app/muzix
ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]