package com.lee.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 减库存
 */
public class SubStock {
    private static RedissonClient client;
    private static RLock rLock;
    private static String goodsKey = "goods:";

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        client = Redisson.create(config);
        rLock = client.getLock("reduceGoodsLock");
    }

    public static String getGoodsKey(Goods goods) {
        return goodsKey + goods.getId();
    }

    public void createGoods(Goods goods) throws Exception {
        String key = getGoodsKey(goods);

        if (client.getAtomicLong(key).isExists()) {
            throw new Exception("商品已经存在");
        }

        client.getAtomicLong(key).set(goods.getStock());
    }

    public void reduceGoods(Goods goods) throws Exception {
        String key = getGoodsKey(goods);
        try {
            rLock.lock();
            if (client.getAtomicLong(key).get() > 0) {
                client.getAtomicLong(key).decrementAndGet();
            } else {
                throw new Exception("库存少于1");
            }
        } finally {
            rLock.unlock();
        }
    }

    public static void main(String[] args) {
        SubStock subStock = new SubStock();
        Goods goods = new Goods(1, 10);
        try {
            subStock.createGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 12; i++) {
            executorService.execute(() -> {
                try {
                    subStock.reduceGoods(goods);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("商品数量不足");
                }
            });
        }
        executorService.shutdown();
        System.out.println(10);
        try {
            executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.shutdown();
    }
}
