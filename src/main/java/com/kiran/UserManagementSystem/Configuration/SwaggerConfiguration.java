package com.kiran.UserManagementSystem.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
        info = @Info(
                title = "USER MANAGEMENT SYSTEM",
                description = "A simple application for user management",
                version = "1.0.0",
                contact = @Contact(
                        name = "kiran",
                        url = "kiran.com",
                        email = "a.kiransrisai@gmail.com"
                ),
                license = @License(
                        name = "Microsoft Licenced",
                        url = "kiran.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Additional documentation for user management system",
                url = "http://localhost:8080/swagger-ui/index.html"
        )

)
public class SwaggerConfiguration {
}
