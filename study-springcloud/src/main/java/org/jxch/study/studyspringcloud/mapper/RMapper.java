package org.jxch.study.studyspringcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jxch.study.studyspringcloud.entity.dao.R;

import java.util.List;

@Mapper
public interface RMapper {

    @Select("select * from r")
    List<R> selectAll();

}
