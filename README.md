# CableCashAPI

## Descrição
CableCashAPI é uma aplicação Spring Boot que fornece uma API para gerenciar transações financeiras. A aplicação utiliza PostgreSQL como banco de dados e é configurada para ser executada em um ambiente Docker.

## Requisitos
- Java 17
- Gradle
- Docker
- Docker Compose

## Configuração do Projeto

### Arquivo `application.yml`
O arquivo `application.yml` configura o nome da aplicação e o perfil ativo:
```yaml
spring:
  application:
    name: CableCashAPI

  profiles:
    active: prod
```

### Arquivo `build.gradle`
O arquivo `build.gradle` configura os plugins, dependências e tarefas do Gradle:
```groovy
plugins {
	id 'java'
	id 'jacoco'
	id 'org.springframework.boot' version '3.3.2'
	id 'io.spring.dependency-management' version '1.1.6'
}

group = 'com.cablecash'
version = '0.0.1-SNAPSHOT'

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

jacoco {
	toolVersion = "0.8.8"
}

jacocoTestReport {
	reports {
		html.required = true
	}
	afterEvaluate {
		classDirectories.setFrom(files(classDirectories.files.collect {
			fileTree(dir: it,
					exclude: ['**/com/cablecash/api/enums/**',
							  '**/com/cablecash/api/config/**',
							  '**/com/cablecash/api/exception/**',
							  '**/com/cablecash/api/service/validator/**',
							'**/com/cablecash/api/App.class'
					])
		}))
	}
}

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'
	implementation 'org.springframework:spring-core'
	implementation 'javax.servlet:javax.servlet-api:4.0.1'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'org.postgresql:postgresql'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
	useJUnitPlatform()
	finalizedBy jacocoTestReport
}

jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = 0.10
			}
		}
	}
}

test {
	finalizedBy jacocoTestCoverageVerification
}

test {
	enabled = false
}
```

### Arquivo `Dockerfile`
O arquivo `Dockerfile` configura a imagem Docker para a aplicação:
```dockerfile
FROM openjdk:17
LABEL authors="antonio"

WORKDIR /app

COPY . .

COPY build/libs/CableCashAPI-0.0.1-SNAPSHOT.jar CableCash.jar

EXPOSE 8080

CMD ["java", "-jar", "CableCash.jar"]
```

### Arquivo `compose.yaml`
O arquivo `compose.yaml` configura os serviços Docker para a aplicação e o banco de dados:
```yaml
version: '3'

services:
  db:
    image: 'postgres:12'
    container_name: 'cablecash-db'
    environment:
      - 'POSTGRES_DB=CableCashDB'
      - 'POSTGRES_PASSWORD=postgres'
      - 'POSTGRES_USER=postgres'
    volumes:
      - 'cablecash-data:/var/lib/postgresql/data'
    ports:
      - '5456:5432'

  test:
    image: 'postgres:12'
    container_name: 'cablecash-db-test'
    environment:
      - 'POSTGRES_DB=CableCashDB'
      - 'POSTGRES_PASSWORD=test'
      - 'POSTGRES_USER=test'
    ports:
      - '5455:5432'

  app:
    build: .
    container_name: 'cablecash-api'
    depends_on:
      - 'db'
    environment:
      - 'SPRING_PROFILES_ACTIVE=prod'
      - 'SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5456/CableCashDB'
      - 'SPRING_DATASOURCE_USERNAME=postgres'
      - 'SPRING_DATASOURCE_PASSWORD=postgres'
    ports:
      - "8080:8080"

volumes:
  cablecash-data:
```

## Como Executar

### Usando Docker Compose
1. Certifique-se de que o Docker e o Docker Compose estão instalados.
2. No diretório raiz do projeto, execute:
   ```sh
   docker-compose up --build
   ```
3. A aplicação estará disponível em `http://localhost:8080`.

### Usando Gradle
1. Certifique-se de que o Java 17 e o Gradle estão instalados.
2. No diretório raiz do projeto, execute:
   ```sh
   ./gradlew bootRun
   ```
3. A aplicação estará disponível em `http://localhost:8080`.

## Testes
Para executar os testes, use o comando:
```sh
./gradlew test
```

## Cobertura de Testes
Para gerar o relatório de cobertura de testes, use o comando:
```sh
./gradlew jacocoTestReport
```
O relatório estará disponível no diretório `build/reports/jacoco/test/html`.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
