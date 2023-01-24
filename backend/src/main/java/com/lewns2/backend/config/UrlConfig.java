package com.lewns2.backend.config;

import com.lewns2.backend.repository.UrlRepository;
import com.lewns2.backend.repository.jpa.JpaUrlRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig {

    @Bean
    public UrlRepository urlRepository() {
        return new JpaUrlRepositoryImpl();
    }

}
