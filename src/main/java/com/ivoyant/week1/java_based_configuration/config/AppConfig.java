package com.ivoyant.week1.java_based_configuration.config;

import com.ivoyant.week1.java_based_configuration.Alien;
import com.ivoyant.week1.java_based_configuration.Computer;
import com.ivoyant.week1.java_based_configuration.Desktop;
import com.ivoyant.week1.java_based_configuration.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    //spring will create bean for Desktop class adds it to container
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }
    @Bean(name={"lap"})
    public Laptop laptop(){
        return new Laptop();
    }
    @Bean
    public Alien alien(){
        //using constructor injection to inject Computer dependency to alien bean
        return new Alien(desktop());//desktop returns Desktop object
    }


}
