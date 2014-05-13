package com.me.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.io.ClassPathResource

/**
 * Created by chrislin on 5/12/2014.
 */
@Configuration
@PropertySource("classpath:/app-spring.properties")
@ComponentScan(basePackages = ["com.me.config", "com.me.resource", "com.me.service"])
class SpringConfig {
    @Value('${mb_value1}') String v1

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        new PropertySourcesPlaceholderConfigurer()
    }

    @Bean(name="myBean")
    MyBean MyBean() {
        return new MyBean(value1:v1);
    }

}
