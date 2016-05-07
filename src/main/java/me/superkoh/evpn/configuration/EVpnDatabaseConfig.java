package me.superkoh.evpn.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by KOH on 16/4/19.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "me.superkoh.evpn.domain.mapper.evpn", sqlSessionFactoryRef = "eVpnSqlSessionFactory")
@PropertySource("classpath:/mybatis/mybatis-${env:prod}.properties")
public class EVpnDatabaseConfig {

    @Autowired
    private Environment env;

    @Bean(name = "eVpnDataSource")
    public DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setDriverClassName(env.getProperty("datasource.evpn.driver-class-name"));
        configuration.setJdbcUrl(env.getProperty("datasource.evpn.url"));
        configuration.setUsername(env.getProperty("datasource.evpn.username"));
        configuration.setPassword(env.getProperty("datasource.evpn.password"));
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
