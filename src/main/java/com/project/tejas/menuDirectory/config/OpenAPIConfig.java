package com.project.tejas.menuDirectory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info()
                .title("Menu Directory Service API")
                .version("1.0.0")
                .description("API Documentation for Menu Directory Service")
        );
    }
}
