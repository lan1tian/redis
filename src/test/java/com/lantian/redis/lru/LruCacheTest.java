package com.lantian.redis.lru;

import org.junit.Test;

import java.util.Map;


public class LruCacheTest {

    @Test
    public void testLruCache() {
        LruCache<String, String> cache = new LruCache<String, String>(16);
        for (int i = 0; i < 20; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
            cache.entrySet().iterator().next();
        }
        System.out.println(1);
    }

}
