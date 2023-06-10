package org.jxch.study.studyspringcloud.boot.bean;

import org.jxch.study.studyspringcloud.boot.core.AutoConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAutoConfig implements AutoConfig {

    @Bean
    @ConditionalOnMissingBean(BeanTest.class)
    public BeanTest beanTest() {
        return new BeanTest("test");
    }

}
