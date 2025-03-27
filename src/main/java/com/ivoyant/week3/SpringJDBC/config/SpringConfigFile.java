package com.ivoyant.week3.SpringJDBC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {

    //configuring datasource
    @Bean
    public DriverManagerDataSource datasource(){
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setDriverClassName("org.postgresql.Driver");
        datasource.setUrl("jdbc:postgresql://localhost:5432/SpringJDBC");
        datasource.setUsername("postgres");
        datasource.setPassword("1234");
        return datasource;
    }
    //injecting datasource dependency into JdbcTemplate bean
    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource datasource){
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(datasource);
        return template;
    }
}
