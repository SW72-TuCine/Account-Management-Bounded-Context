FROM openjdk:17-alpine

# Copia el archivo JAR a la raíz del sistema de archivos en el contenedor
COPY ./target/account-management-0.0.1-SNAPSHOT.jar /account-management-0.0.1-SNAPSHOT.jar

# Establece el comando de entrada para ejecutar el archivo JAR con Java
ENTRYPOINT ["java", "-jar", "/account-management-0.0.1-SNAPSHOT.jar"]