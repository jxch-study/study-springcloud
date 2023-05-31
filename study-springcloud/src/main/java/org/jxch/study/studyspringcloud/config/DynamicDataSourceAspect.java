package org.jxch.study.studyspringcloud.config;

import lombok.NonNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class DynamicDataSourceAspect {

    @Before(value = "@annotation(dds)", argNames = "point,dds")
    public void before(JoinPoint point, @NonNull DDS dds) {
        DSType type = dds.value();
        DynamicDataSource.name.set(type);
    }

}
