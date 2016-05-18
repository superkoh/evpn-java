package me.superkoh.evpn.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.superkoh.evpn.configuration.properties.EVpnMybatisProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by KOH on 16/4/19.
 */
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(EVpnMybatisProperties.class)
@MapperScan(value = "me.superkoh.evpn.domain.mapper.evpn", sqlSessionFactoryRef = "eVpnSqlSessionFactory")
public class EVpnDatabaseConfig {

    @Autowired
    private EVpnMybatisProperties mybatisProperties;

    @Bean(name = "eVpnDataSource")
    public DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName(mybatisProperties.getDriverClassName());
        configuration.setJdbcUrl(mybatisProperties.getUrl());
        configuration.setUsername(mybatisProperties.getUsername());
        configuration.setPassword(mybatisProperties.getPassword());
        configuration.setAutoCommit(false);
        return new HikariDataSource(configuration);
    }

    @Bean(name = "eVpnTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("eVpnDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "eVpnSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("eVpnDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean(name = "eVpnSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("eVpnSqlSessionFactory") SqlSessionFactory
                                                         sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
