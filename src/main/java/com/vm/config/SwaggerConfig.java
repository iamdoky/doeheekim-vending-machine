package com.vm.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        SecurityScheme apiKey = new SecurityScheme()
            .type(SecurityScheme.Type.APIKEY)
            .in(SecurityScheme.In.HEADER)
            .name("Authorization");

        SecurityRequirement securityRequirement = new SecurityRequirement()
            .addList("Bearer Token");

        return new OpenAPI()
            .components(new Components().addSecuritySchemes("Bearer Token", apiKey))
            .info(new Info()
                .title("[3o3]")
                .description("3o3 API Server")
                .version("0.0.1"))
            .addSecurityItem(securityRequirement);
    }
}