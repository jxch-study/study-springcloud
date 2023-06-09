package org.jxch.study.studyspringcloud.id;

import com.tencent.devops.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLeafServer
@SpringBootApplication
public class IDAPP {
    public static void main(String[] args) {
        SpringApplication.run(IDAPP.class, args);
    }
}
