package org.jxch.study.studyspringcloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
@RequiredArgsConstructor
public class DynamicDataSource extends AbstractRoutingDataSource {
    // 当前使用的数据源标识
    public static ThreadLocal<DSType> name=new ThreadLocal<>();
    private final DataSource dsr1;
    private final DataSource dsw1;

    // 返回当前数据源标识
    @Override
    protected Object determineCurrentLookupKey() {
        return name.get();
    }

    @Override
    public void afterPropertiesSet() {
        // 为targetDataSources初始化所有数据源
        Map<Object, Object> targetDataSources=new HashMap<>();
        targetDataSources.put(DSType.W1,dsw1);
        targetDataSources.put(DSType.R1,dsr1);
        super.setTargetDataSources(targetDataSources);
        // 为defaultTargetDataSource 设置默认的数据源
        super.setDefaultTargetDataSource(dsw1);
        super.afterPropertiesSet();
    }

}
