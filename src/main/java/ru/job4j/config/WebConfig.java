package ru.job4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("ru.job4j")
public class WebConfig {

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
