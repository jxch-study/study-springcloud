package org.jxch.study.studyspringcloud.service.impl;

import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import org.jxch.study.studyspringcloud.config.DDS;
import org.jxch.study.studyspringcloud.config.DSType;
import org.jxch.study.studyspringcloud.mapper.RMapper;
import org.jxch.study.studyspringcloud.mapper.WMapper;
import org.jxch.study.studyspringcloud.service.SelectService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectService {
    private final RMapper rMapper;
    private final WMapper wMapper;

    @DDS(DSType.W1)
    @Override
    public String selectWAll() {
        return JSON.toJSONString(wMapper.selectAll());
    }

    @DDS(DSType.R1)
    @Override
    public String selectRAll() {
        return JSON.toJSONString(rMapper.selectAll());
    }

}
