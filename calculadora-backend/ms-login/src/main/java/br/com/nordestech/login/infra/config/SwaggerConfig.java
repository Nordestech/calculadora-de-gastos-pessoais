package br.com.nordestech.login.infra.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("loginSwaggerConfig")
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi loginApi() {
        return GroupedOpenApi.builder()
                .group("Login")
                .pathsToMatch("/login/**")
                .build();
    }

}