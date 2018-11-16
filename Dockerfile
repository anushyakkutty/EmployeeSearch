FROM openjdk:8-jdk-alpine
RUN mkdir /code
WORKDIR /code
ADD ./build/libs/esearch-0.0.1-SNAPSHOT.jar /code/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/code/esearch-0.0.1-SNAPSHOT.jar"]
