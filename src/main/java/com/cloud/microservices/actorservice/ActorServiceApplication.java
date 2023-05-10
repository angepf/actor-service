package com.cloud.microservices.actorservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Actor Service",
                description = "Spring Actor Service",
                version = "v1.0",
                contact = @Contact(
                        name = "Angélica Pinos",
                        email = "bpinos@est.ups.edu.ec",
                        url = "ups.edu.ec"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "ups.edu.ec"
                )
        )
)
public class ActorServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run( ActorServiceApplication.class, args );
    }
}

