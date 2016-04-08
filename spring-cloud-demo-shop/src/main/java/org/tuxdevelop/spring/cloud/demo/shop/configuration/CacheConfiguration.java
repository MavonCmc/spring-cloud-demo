package org.tuxdevelop.spring.cloud.demo.shop.configuration;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager productsCacheManager() {
        final GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder
                .newBuilder()
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .maximumSize(10));
        return cacheManager;
    }

}
