package org.jxch.study.studyspringcloud.app;

import org.jxch.study.studyspringcloud.boot.bean.BeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    private BeanTest beanTest;

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(beanTest.name());
    }
}
