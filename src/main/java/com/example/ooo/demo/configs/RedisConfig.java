package com.example.ooo.demo.configs;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean
    public Config config() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress("redis://localhost:7000", "redis://localhost:7001")
                .setPassword("aaqqewwe");

        return config;
    }
}