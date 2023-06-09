package org.jxch.study.studyspringcloud.order.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.jxch.study.studyspringcloud.order.config.MinioProperty;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class MinioService {
    private final MinioClient minioClient;
    private final MinioProperty minioProperty;

    public void uploadFile(String objectName, String filePath) throws Exception {
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioProperty.getBucketName())
                .object(objectName)
                .stream(new FileInputStream(filePath), Files.size(Paths.get(filePath)), -1)
                .build();

        minioClient.putObject(args);
    }

    public void downloadFile(String objectName, String filePath) throws Exception {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(minioProperty.getBucketName())
                .object(objectName)
                .build();

        String content = minioClient.getObject(args).object();

        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes());
    }

}
