package br.com.nordestech.usuario.infra.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("usuarioSwaggerConfig")
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi usuarioApi() {
        return GroupedOpenApi.builder()
                .group("Usuário")
                .pathsToMatch("/usuario/**")
                .build();
    }

}