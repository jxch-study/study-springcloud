package org.jxch.study.studyspringcloud.order;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.jxch.study.studyspringcloud.order.dao.mongo.UserMongoRepository;
import org.jxch.study.studyspringcloud.order.entity.mongo.UserMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserMongoRepTest {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Test
    public void mongoTest() {
        userMongoRepository.save(new UserMongo("jxch", 26));
        UserMongo jxch = userMongoRepository.findByName("jxch");
        log.info(JSON.toJSONString(jxch));
    }

}
