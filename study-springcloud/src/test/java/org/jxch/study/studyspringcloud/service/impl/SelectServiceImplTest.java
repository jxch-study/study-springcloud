package org.jxch.study.studyspringcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.jxch.study.studyspringcloud.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SelectServiceImplTest {
    @Autowired
    private SelectService selectService;

    @Test
    void selectWAll() {
        log.info(selectService.selectWAll());
    }

    @Test
    void selectRAll() {
        log.info(selectService.selectRAll());
    }

}