package org.jxch.study.studyspringcloud.app;

import org.jxch.study.studyspringcloud.boot.bean.BeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BeanTest beanTest() {
        return new BeanTest("app");
    }

}
