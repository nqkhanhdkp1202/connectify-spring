package com.klgroup.connectify.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;



@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Connectify Application API").description(
                        "Sample description."));
    }
    @Bean
    public GroupedOpenApi authApi() {
        final String[] packagesToScan = {"com.klgroup.connectify.controller"};
        return GroupedOpenApi
                .builder()
                .group("Auth API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/auth/**")
                .addOpenApiCustomizer(bearerAuthCustomizer())
                .addOpenApiCustomizer(tagsSorterCustomizer())
                .build();
    }

    @Bean
    public GroupedOpenApi testApi() {
        final String[] packagesToScan = {"com.klgroup.connectify.controller"};
        return GroupedOpenApi
                .builder()
                .group("Test API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/test/**")
                .addOpenApiCustomizer(bearerAuthCustomizer())
                .addOpenApiCustomizer(tagsSorterCustomizer())
                .build();
    }

    private OpenApiCustomizer bearerAuthCustomizer() {
        return openAPI -> openAPI
                .schemaRequirement("Bearer", new SecurityScheme()
                        .name("Authorization")
                        .description("JWT Authorization header using the Bearer scheme. Example: \\\\\\\"Authorization: Bearer {token}\\\\\\\"")
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                )
                .security(Collections.singletonList(new SecurityRequirement().addList("Bearer")));
    }
    private OpenApiCustomizer tagsSorterCustomizer() {
        return openAPI -> openAPI
                .tags(openAPI.getTags().stream()
                        .sorted(Comparator.comparing(Tag::getName)).collect(Collectors.toList()));

    }
}
