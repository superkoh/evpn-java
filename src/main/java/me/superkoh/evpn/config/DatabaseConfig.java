package me.superkoh.evpn.config;

/**
 * Created by KOH on 16/4/19.
 */
//@Configuration
//@EnableTransactionManagement
//@MapperScan("me.superkoh.evpn.domain.mapper")
public class DatabaseConfig {

//    @Autowired
//    Environment env;
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        config.setJdbcUrl(env.getProperty("spring.datasource.url"));
//        config.setUsername(env.getProperty("spring.datasource.username"));
//        config.setPassword(env.getProperty("spring.datasource.password"));
//        config.setAutoCommit(false);
//        return new HikariDataSource(config);
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        List<Resource> resources = new ArrayList<Resource>();
//        String mapperLocation = env.getProperty("mybatis.mapper-locations");
//        if (mapperLocation != null) {
//            Resource[] mappers;
//            try {
//                mappers = new PathMatchingResourcePatternResolver().getResources(mapperLocation);
//                resources.addAll(Arrays.asList(mappers));
//            } catch (IOException e) {
//
//            }
//        }
//        Resource[] mapperLocations = new Resource[resources.size()];
//        mapperLocations = resources.toArray(mapperLocations);
//        sessionFactory.setMapperLocations(mapperLocations);
//        return sessionFactory.getObject();
//    }

}
