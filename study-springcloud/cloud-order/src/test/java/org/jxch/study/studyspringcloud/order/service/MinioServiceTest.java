package org.jxch.study.studyspringcloud.order.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MinioServiceTest {
    @Autowired
    private MinioService minioService;

    @Test
    void uploadFile() throws Exception {
        minioService.uploadFile("order-test", "E:\\work\\jxch-study\\study-springcloud\\study-springcloud\\cloud-order\\src\\main\\resources\\order-test1.txt");
    }

    @Test
    void downloadFile() throws Exception {
        minioService.downloadFile("order-test", "E:\\work\\jxch-study\\study-springcloud\\study-springcloud\\cloud-order\\src\\main\\resources\\order-test1-d.txt");
    }
}