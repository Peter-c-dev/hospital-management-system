package org.example.hospital.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hospitalApi() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Hospital API")
                                .version("1.0")
                                .description("Hospital Management Backend API")
                );
    }
}