package com.lee.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 分布式锁
 */
@Component
@Slf4j
public class RedisLockDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        RedissonClient client = Redisson.create(config);

        RLock lock = client.getLock("anyLock");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                lock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " - " + System.currentTimeMillis());
                lock.unlock();
            });
        }

    }
}
