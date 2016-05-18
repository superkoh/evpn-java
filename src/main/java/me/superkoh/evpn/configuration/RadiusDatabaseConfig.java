package me.superkoh.evpn.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.superkoh.evpn.configuration.properties.RadiusMybatisProperties;
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
@EnableConfigurationProperties(RadiusMybatisProperties.class)
@MapperScan(value = "me.superkoh.evpn.domain.mapper.radius", sqlSessionFactoryRef = "radiusSqlSessionFactory")
public class RadiusDatabaseConfig {

    @Autowired
    private RadiusMybatisProperties mybatisProperties;

    @Bean(name = "radiusDataSource")
    public DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName(mybatisProperties.getDriverClassName());
        configuration.setJdbcUrl(mybatisProperties.getUrl());
        configuration.setUsername(mybatisProperties.getUsername());
        configuration.setPassword(mybatisProperties.getPassword());
        configuration.setAutoCommit(false);
        return new HikariDataSource(configuration);
    }

    @Bean(name = "radiusTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("radiusDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "radiusSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("radiusDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean(name = "radiusSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("radiusSqlSessionFactory") SqlSessionFactory
                                                             sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
