package com.example.swagger.config;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI configurarOpenApi() {
        // Información de contacto
        Contact contacto = new Contact()
                .name("Sebastian Barros Gallardo")
                .email("sebastian.barros@gmail.com")
                .url("https://www.duocuc.cl");

        // Licencia del proyecto
        License licencia = new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");

        // Información principal de la API
        Info informacionApi = new Info()
                .description("""
                        API para la administracion
                        de equipos tecnologicos
                        """)
                .version("1.0")
                .termsOfService("http://www.duocuc.cl")
                .contact(contacto)
                .license(licencia);

        // Documentación externa (GitHub)
        ExternalDocumentation github = new ExternalDocumentation()
                .description("Repositorio ofical del proyecto en GitHub")
                .url("https://github.com/sebastian-barros-gallardo");

        // Configuración OpenAPI
        return new OpenAPI()
                .info(informacionApi)
                .externalDocs(github);
    }
}
