package org.jxch.study.studyspringcloud.service.impl;

import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import org.jxch.study.studyspringcloud.mapper.r.RMapper;
import org.jxch.study.studyspringcloud.mapper.w.WMapper;
import org.jxch.study.studyspringcloud.service.SelectService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectService {
    private final RMapper rMapper;
    private final WMapper wMapper;

    @Override
    public String selectWAll() {
        return JSON.toJSONString(wMapper.selectAll());
    }

    @Override
    public String selectRAll() {
        return JSON.toJSONString(rMapper.selectAll());
    }

}