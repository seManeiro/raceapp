FROM adoptopenjdk/maven-openjdk11
COPY . /usr/app
WORKDIR /usr/app
RUN mvn compile
RUN mvn package
CMD [ "java", "-jar", "cd target/travrace-0.0.1.jar"]