package com.exemplo.placar.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(
    info = @Info(title = "Placar API", version = "1.0", description = "Documentação da API Placar")
)
public class JaxRsConfig extends Application {
}
