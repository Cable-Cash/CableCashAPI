/*
 * Projeto Integrador do Curso de Java.
 * Todos os direitos reservados. Uso sujeito aos termos de licença.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.cablecash.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// http://localhost:8080/swagger-ui/index.html
// http://localhost:8080/v3/api-docs
/**
 * A classe {@code SwaggerConfig} é responsável pela configuração do <em>Swagger</em> no projeto.
 *
 * <p>Esta configuração define as informações básicas da API, como título, versão, e descrição,
 * além de especificar o servidor onde a API está hospedada. O objetivo é fornecer uma
 * documentação detalhada e acessível para os desenvolvedores e usuários que interagem com a API.
 *
 * @author Antonio Carlos
 * @see <a href="https://swagger.io/">Swagger</a>
 */
@Configuration
@EnableWebMvc
@OpenAPIDefinition(
        info = @Info(
                title = "Documentação CableCash API",
                version = "0.0.1",
                description = "Documentação da API de CableCash do Projeto Integrador."
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "URL de acesso a API"
        )
)
public class SwaggerConfig {

    /**
     * Configura a documentação do <em>OpenAPI</em> para o grupo "default".
     *
     * <p>Este método cria um bean que define o agrupamento dos endpoints da API
     * sob o nome "default", permitindo que todos os endpoints correspondentes ao
     * padrão de caminho especificado (neste caso, "/**") sejam documentados.
     *
     * @return {@code GroupedOpenApi} objeto que contém a configuração do grupo de endpoints da API.
     */
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/**")
                .build();
    }
}