package org.jxch.study.studyspringcloud.id.config;

import com.tencent.devops.leaf.IDGen;
import com.tencent.devops.leaf.snowflake.SnowflakeIDGenImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Configuration
public class IDConfig {
    @Bean
    public IDGen idGen(@NonNull LeafProperties leafProperties) {
        return new SnowflakeIDGenImpl(leafProperties.getZkAddress(), leafProperties.getZkPort());
    }
}
