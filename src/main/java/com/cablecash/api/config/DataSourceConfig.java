//package com.cablecash.api.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url(System.getenv("DB_URL") + "/CableCashDB");
//        dataSourceBuilder.username(System.getenv("DB_USERNAME"));
//        dataSourceBuilder.password(System.getenv("DB_PASSWORD"));
//
//        return dataSourceBuilder.build();
//    }
//
//}
