package org.jxch.study.studyspringcloud.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jxch.study.studyspringcloud.entity.dao.W;

import java.util.List;

@Mapper
public interface WMapper {
    @DS("w1")
    @Select("select * from w")
    List<W> selectAll();
}
