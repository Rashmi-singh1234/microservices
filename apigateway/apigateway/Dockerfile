FROM openjdk:11
EXPOSE 8999
ADD target/apigateway.jar apigateway.jar
ENTRYPOINT ["java","-jar","/apigateway.jar"]