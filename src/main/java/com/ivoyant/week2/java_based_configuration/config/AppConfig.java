package com.ivoyant.week1.java_based_configuration.config;

import com.ivoyant.week1.java_based_configuration.Alien;
import com.ivoyant.week1.java_based_configuration.Computer;
import com.ivoyant.week1.java_based_configuration.Desktop;
import com.ivoyant.week1.java_based_configuration.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class AppConfig {

    //spring will create bean for Desktop class adds it to container
    @Bean
    public Desktop desktop(){
        return new Desktop();
    }
    @Bean(name={"lap"})
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }
    @Bean
    public Alien alien(@Qualifier("lap") Computer com){//autowiring byName using @Qualifier("beanName")
        //using injected dependency to set the property of Alien class
        //we can set the property either through setter injection or constructor injection
        return new Alien(com);//using constructor injection to set com property of Alien
    }


}
