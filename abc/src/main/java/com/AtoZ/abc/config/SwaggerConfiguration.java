package com.AtoZ.abc.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("AtoZ Api")
                        .description("AtoZ's api docs!!")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("localhost:8080")))
                .externalDocs(new ExternalDocumentation()
                        .description("AtoZ's  Wiki Documentation")
                        .url("localhost:8080/spring.wiki.github.org/docs"));
    }
}
