package org.jxch.study.studyspringcloud.id.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class LeafServiceTest {
    @Autowired
    private LeafService leafService;

    @Test
    void nextId() {
        log.info("id: {}", leafService.nextId());
    }

}