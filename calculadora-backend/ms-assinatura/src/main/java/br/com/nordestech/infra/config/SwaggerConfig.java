package br.com.nordestech.infra.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("assinaturaSwaggerConfig")
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi assinaturaApi() {
        return GroupedOpenApi.builder()
                .group("Assinatura")
                .pathsToMatch("/api/assinatura/**")
                .build();
    }

}