package org.jxch.study.studyspringcloud.id.controller;

import com.tencent.devops.leaf.service.SnowflakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
@RequiredArgsConstructor
public class IDController {
    private final SnowflakeService snowflakeService;

    @RequestMapping(path = "/nextId", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Long> nextId() {
        return ResponseEntity.ok(snowflakeService.getId("").getId());
    }

}
