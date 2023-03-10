package com.lewns2.backend.config;

import com.lewns2.backend.repository.UrlRepository;
import com.lewns2.backend.repository.jpa.JpaUrlRepositoryImpl;
import com.lewns2.backend.service.url.UrlService;
import com.lewns2.backend.service.url.UrlServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig {

    @Bean
    public UrlRepository urlRepository() {
        return new JpaUrlRepositoryImpl();
    }

    @Bean
    public UrlService urlService() {
        return new UrlServiceImpl(urlRepository());
    }
}
