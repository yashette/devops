# Utilisation de l'image Java 17 Alpine officielle comme base
FROM eclipse-temurin:17-jre-alpine

# Création du répertoire de travail dans le conteneur
WORKDIR /springboot-software

# Copie du fichier JAR de l'application dans le répertoire de travail
COPY springboot-rest-demo-ws/target/springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar .

# Copie du fichier de configuration dans le répertoire de travail
COPY springboot-rest-demo-config/src/main/resources/springboot-rest-demo.yml .

# Exposition du port 8080 pour l'application
EXPOSE 8080

# Commande pour exécuter l'application Java
CMD ["java", "-jar", "springboot-rest-demo-ws-1.0.0-SNAPSHOT.jar"]

