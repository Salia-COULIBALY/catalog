package ml.e_jago.catalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

        private final String securitySchemeName = "bearerAuth";

        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                                .info(
                                                new Info()
                                                                .title("API de Gestion du Catalogue - e-Jago")
                                                                .description(""
                                                                                + "Cette API permet de gérer les catégories et les produits "
                                                                                + "dans le cadre de l'application e-Jago. "
                                                                                + "Elle offre des fonctionnalités pour créer, lire, mettre à jour "
                                                                                + "et supprimer des catégories et des produits.")
                                                                .version("1.0.0")
                                                                .contact(new Contact()
                                                                                .name("COULIBALY Salia")
                                                                                .email("s.coulibaly@e-jago.ml")
                                                                                .url("https://e-jago.ml")))
                                .servers(List.of(
                                                new Server().url("http://localhost:8082")
                                                                .description("Environnement local"),
                                                new Server().url("https://api.e-jago.ml")
                                                                .description("Serveur de Production")))
                                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                                .components(
                                                new io.swagger.v3.oas.models.Components()
                                                                .addSecuritySchemes(
                                                                                securitySchemeName,
                                                                                new SecurityScheme()
                                                                                                .name(securitySchemeName)
                                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                                .scheme("bearer")));
        }

        /*
         * @Bean
         * public GroupedOpenApi productApi() {
         * return GroupedOpenApi.builder()
         * .group("Products")
         * .pathsToMatch("/api/products/**")
         * .build();
         * }
         * 
         * @Bean
         * public GroupedOpenApi categoryApi() {
         * return GroupedOpenApi.builder()
         * .group("Categories")
         * .pathsToMatch("/api/categories/**")
         * .build();
         * }
         */

}