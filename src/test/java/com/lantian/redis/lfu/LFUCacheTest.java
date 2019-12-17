package com.lantian.redis.lfu;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LFUCacheTest {

    private LFUCache<String, String> lfuCache = new LFUCache<>(16);

    @Test
    public void put() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            lfuCache.put("key-" + i, "value-" + i);
            int accessCount = random.nextInt(25) ;
            for (int j = 0; j < accessCount; j++) {
                String key = "key-" + random.nextInt(i+1);
                lfuCache.get(key);
            }
        }
        System.out.println();
    }

    @Test
    public void get() throws Exception {
    }

}