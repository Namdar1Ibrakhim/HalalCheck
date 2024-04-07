package com.example.halalcheck.config;

import com.example.halalcheck.util.MinioProperties;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioProperties.getUrl())
                .credentials(minioProperties.getAccessKey(),
                        minioProperties.getSecretKey())
                .build();
    }

}
