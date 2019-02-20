package com.example.ooo.demo;

import org.redisson.Redisson;
import org.redisson.RedissonNode;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;
import org.redisson.config.Config;
import org.redisson.config.RedissonNodeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TaskRunning {
    public static void main(String[] args) {
        SpringApplication.run(TaskRunning.class, args);
    }

    @Autowired
    Config config;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws ExecutionException, InterruptedException {
        RedissonClient redisson = Redisson.create(config);

        RedissonNodeConfig nodeConfig = new RedissonNodeConfig(config);
        nodeConfig.setExecutorServiceWorkers(Collections.singletonMap("myExecutor", 2));
        RedissonNode node = RedissonNode.create(nodeConfig);
        node.start();
    }
}
