package com.lantian.redis.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;


    public LruCache(int capacity) {
        super((int) (Math.ceil(capacity / 0.75) + 1), 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //将当前缓存中最不常访问的元素打印出来
        System.out.println(eldest.getKey() + ":" + eldest.getValue());
        return this.size() > capacity;
    }


}
