FROM openjdk:8-jre
WORKDIR /application
EXPOSE 8090
ADD app.jar /application/app.jar
ADD application.properties /application/application.properties
CMD java -Dspring.config.location=/application/application.properties -jar /application/app.jar
