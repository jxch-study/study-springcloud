package org.jxch.study.studyspringcloud.order.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class MinioConfig {
    @Bean
    public MinioClient minioClient(@NonNull MinioProperty minioProperty) {
        return MinioClient.builder()
                .endpoint(minioProperty.getEndpoint())
                .credentials(minioProperty.getAccessKey(), minioProperty.getSecretKey())
                .build();
    }
}
