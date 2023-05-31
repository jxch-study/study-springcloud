package org.jxch.study.studyspringcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jxch.study.studyspringcloud.entity.dao.W;

import java.util.List;

@Mapper
public interface WMapper {

    @Select("select * from w")
    List<W> selectAll();

}
