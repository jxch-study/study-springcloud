package org.jxch.study.studyspringcloud.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.jxch.study.studyspringcloud.mapper.w", sqlSessionFactoryRef = "wSqlSessionFactory")
public class WMyBatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.w1")
    public DataSource dsw1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory wSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dsw1());
        // 指定对应的mapper.xml文件
        // sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/w/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager wTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dsw1());
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate wTransactionTemplate(){
        return new TransactionTemplate(wTransactionManager());
    }

}
