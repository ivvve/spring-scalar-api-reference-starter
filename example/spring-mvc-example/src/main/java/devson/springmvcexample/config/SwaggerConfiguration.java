package devson.springmvcexample.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info().title("Scalar API Reference - Spring MVC Example"))
            .components(
                // To add authorization info
                new Components().addSecuritySchemes(
                    "Bearer Token",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER)
                        .name("Authorization")
                        .scheme("bearer")
                        .bearerFormat("JWT")
                )
            )
            .addSecurityItem(
                new SecurityRequirement()
                    .addList("Bearer Token")
            );
    }
}
