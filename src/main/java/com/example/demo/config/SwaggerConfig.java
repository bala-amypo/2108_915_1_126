package com.example.demo.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        SecurityScheme bearerScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        Server productionServer = new Server()
                .url("https://9122.408procr.amypo.ai/")
                .description("Production Server");

        Server localServer = new Server()
                .url("http://localhost:9001")
                .description("Local Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Customer Loyalty Tier Upgrader API")
                        .description("JWT-secured API for customer loyalty tier upgrades")
                        .version("1.0.0")
                )
                .servers(List.of(productionServer, localServer))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerScheme)
                )
                .addSecurityItem(
                        new SecurityRequirement().addList("bearerAuth")
                );
    }
}
