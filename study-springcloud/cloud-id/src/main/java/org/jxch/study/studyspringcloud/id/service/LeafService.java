package org.jxch.study.studyspringcloud.id.service;

import com.tencent.devops.leaf.IDGen;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeafService {
    private final IDGen idGen;

    public long nextId() {
        return idGen.get("").getId();
    }

}
