package com.seubolso.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do Swagger/OpenAPI para documentação interativa da API.
 * Após iniciar o projeto, acesse: http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Seu Bolso API")
                .version("1.0.0")
                .description("API REST para gerenciamento financeiro pessoal — projeto Seu Bolso.")
                .contact(new Contact()
                        .name("Equipe Seu Bolso")
                        .email("contato@seubolso.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
