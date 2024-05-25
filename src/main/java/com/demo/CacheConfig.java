package com.demo;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public ConcurrentMapCacheManager cacheManager() {
        return new ConcurrentMapCacheManager("customers");
    }
}

/* cacheManager():  Defines a bean of type ConcurrentMapCacheManager, which is an in-memory cache manager provided by Spring. 
  It creates a cache manager with a single cache named "customers". 
  If you have multiple caches, you can specify them as additional parameters to the ConcurrentMapCacheManager constructor.
*/