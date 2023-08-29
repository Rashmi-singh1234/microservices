FROM openjdk:11
EXPOSE 8081
ADD target/price-service.jar price-service.jar
ENTRYPOINT ["java","-jar","/price-service.jar"]