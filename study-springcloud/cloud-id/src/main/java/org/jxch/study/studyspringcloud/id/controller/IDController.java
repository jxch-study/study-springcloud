package org.jxch.study.studyspringcloud.id.controller;

import lombok.RequiredArgsConstructor;
import org.jxch.study.studyspringcloud.id.service.LeafService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
@RequiredArgsConstructor
public class IDController {
    private final LeafService leafService;

    @RequestMapping(path = "/nextId", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Long> nextId() {
        return ResponseEntity.ok(leafService.nextId());
    }

}
