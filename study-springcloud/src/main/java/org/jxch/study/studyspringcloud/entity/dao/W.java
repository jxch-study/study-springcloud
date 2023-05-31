package org.jxch.study.studyspringcloud.entity.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("w")
public class W {
    @TableId
    private Integer id;
    private String name;
}
