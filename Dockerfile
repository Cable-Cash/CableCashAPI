FROM openjdk:17
LABEL authors="antonio"

WORKDIR /app

COPY . .

COPY build/libs/CableCashAPI-0.0.1-SNAPSHOT.jar CableCash.jar

EXPOSE 8080

CMD ["java", "-jar", "CableCash.jar"]