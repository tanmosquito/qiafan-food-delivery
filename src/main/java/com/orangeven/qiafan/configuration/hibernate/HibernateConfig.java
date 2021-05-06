package com.orangeven.qiafan.configuration.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HibernateConfig {

    @Bean(destroyMethod = "close")
    public BasicDataSource getDataSource() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("driverClassName","org.postgresql.Driver");
        properties.setProperty("url","jdbc:postgresql://localhost:5432/qiafan_food_delivery");
        properties.setProperty("username","app_user");
        properties.setProperty("password","75804184");

        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        return dataSource;
    }

    @Bean
    @Autowired
    public LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.setProperty("hibernate.showsql", "true");
        properties.setProperty("hibernate.id.new_generator_mappings","true");
        //properties.setProperty("hibernate.physical_naming_strategy", ImprovedNamingStrategy.class.getName());
        properties.setProperty("hibernate.implicit_naming_strategy", "default");

        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.setPackagesToScan(
                "com.orangeven.qiafan.app"
        );

        return factoryBean;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager getTransactionManager(LocalSessionFactoryBean factoryBean) {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }
}
