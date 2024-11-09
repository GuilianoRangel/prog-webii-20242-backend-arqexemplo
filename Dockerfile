#Stage 1
# initialize build and set base image for first stage
FROM maven:3.9.6-amazoncorretto-21 as stage1
  # speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
  # set working directory
WORKDIR /app/build
  # copy just pom.xml
COPY pom.xml .

RUN yum install git -y
ADD "https://api.github.com/repos/GuilianoRangel/prog-webii-20242-backend-arquitetura/commits?per_page=1&sha=master" latest_commit
RUN head -c 5 /dev/random > random_bytes && git clone https://github.com/GuilianoRangel/prog-webii-20242-backend-arquitetura.git
RUN head -c 5 /dev/random > random_bytes && cd prog-webii-20242-backend-arquitetura && git checkout master && mvn dependency:go-offline && mvn clean install -Dmaven.test.skip=true && cd ..

ADD "https://api.github.com/repos/GuilianoRangel/prog-webii-20242-backend-adminmodule/commits?per_page=1&sha=master" latest_commit
RUN head -c 5 /dev/random > random_bytes && git clone https://github.com/GuilianoRangel/prog-webii-20242-backend-adminmodule.git
RUN head -c 5 /dev/random > random_bytes && cd prog-webii-20242-backend-adminmodule && git checkout master && mvn dependency:go-offline && mvn clean install -Dmaven.test.skip=true && cd ..

  # go-offline using the pom.xml
RUN mvn dependency:go-offline

  # copy your other files
COPY ./src ./src
  # compile the source code and package it in a jar file
RUN mvn clean install -Dmaven.test.skip=true
  #Stage 2
  # set base image for second stage
FROM openjdk:21-jdk-slim
  # set deployment directory
WORKDIR /app
  # copy over the built artifact from the maven image
COPY --from=stage1 /app/build/target/*.jar /app/app.jar
CMD java -jar /app/app.jar