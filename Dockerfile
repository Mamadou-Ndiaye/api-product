FROM openjdk:11
ADD target/*.jar api-produit.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar" , "api-produit.jar"]