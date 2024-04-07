package com.example.halalcheck;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Library APIS", version = "1.0", description = "HalalCheck Library Management Apis"))
public class HalalCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(HalalCheckApplication.class, args);
    }

}
