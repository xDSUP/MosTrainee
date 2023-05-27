package ru.btproject.traineeservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
class SpringFoxConfig {

    @Bean
    public OpenAPI apiInfo() {
        final OpenAPI openApi = new OpenAPI();
        openApi.info(new Info()
                        .title("MosTrainee API through Swagger UI")
                        .description("List of all the APIs of MosTrainee Application through Swagger UI")
                        .version("1.0"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .security(Arrays.asList(new SecurityRequirement().addList("bearerAuth")));

        return openApi;
    }
}