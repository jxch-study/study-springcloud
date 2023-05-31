package org.jxch.study.studyspringcloud.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.jxch.study.studyspringcloud.mapper.r", sqlSessionFactoryRef = "rSqlSessionFactory")
public class RMyBatisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.r1")
    public DataSource dsr1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory rSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dsr1());
        // 指定对应的mapper.xml文件
        // sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/r/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager rTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dsr1());
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionTemplate rTransactionTemplate(){
        return new TransactionTemplate(rTransactionManager());
    }

}
