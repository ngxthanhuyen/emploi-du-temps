#On utilise l'image Maven pour build le projet
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

#On copie les fichiers de configuration Maven d'abord (pour le caching)
COPY pom.xml .

#On télécharge les dépendances
RUN mvn dependency:go-offline

# Copie le code source
COPY src ./src

# Compile le projet et génère le jar
RUN mvn clean package -DskipTests

#Image légère pour exécuter l'application Java
FROM eclipse-temurin:17-jdk-alpine

#Dossier de travail
WORKDIR /app

#On copie le jav généré
COPY --from=build /app/target/emploi-du-temps-0.0.1-SNAPSHOT.jar app.jar

#Exposition du port
EXPOSE 8080

#Lancement de l'application
ENTRYPOINT ["java", "-jar", "app.jar"]