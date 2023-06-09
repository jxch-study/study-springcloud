package org.jxch.study.studyspringcloud.id.service;

import com.tencent.devops.leaf.service.SnowflakeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class LeafServiceTest {
    @Autowired
    private SnowflakeService snowflakeService;

    @Test
    void nextId() {
        log.info("id: {}", snowflakeService.getId(""));
    }

    @Test
    void zoo() {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .sessionTimeoutMs(10000)
                .connectionTimeoutMs(10000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        curatorFramework.start();
        log.info("curatorFramework: {}", curatorFramework.getState());
        curatorFramework.close();
    }

}