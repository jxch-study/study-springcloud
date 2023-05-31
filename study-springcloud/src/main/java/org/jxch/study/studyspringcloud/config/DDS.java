package org.jxch.study.studyspringcloud.config;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DDS {
    DSType value() default DSType.W1;
}
