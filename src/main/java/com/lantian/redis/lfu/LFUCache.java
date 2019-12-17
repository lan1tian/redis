package com.lantian.redis.lfu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> {

    private Map<K, CacheValue<V>> data;
    private final int capacity;

    public LFUCache(int capacity) {
        this.data = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        if (this.data.size() >= this.capacity) {
            Map.Entry<K, CacheValue<V>> old = Collections.min(this.data.entrySet(), (o1, o2) -> {
                final CacheValue<V> v1 = o1.getValue();
                final CacheValue<V> v2 = o2.getValue();
                if (v1.getCount() != v2.getCount()) {
                    return v1.getCount() - v2.getCount();
                }
                return (int) (v1.getTime() - v2.getTime());
            });
            System.out.println("remove:" + old.getKey() + "," + old.getValue());
            this.data.remove(old.getKey());
        }
        CacheValue old = this.data.get(key);
        if (old != null) {
            old.incCount();
        } else if (this.data.size() >= this.capacity){

            CacheValue<V> cacheValue = new CacheValue<>(value);
            this.data.put(key, cacheValue);
        }
    }


    public V get(K key) {
        final CacheValue<V> cacheValue = this.data.get(key);
        if (cacheValue != null) {
            cacheValue.incCount();
            return cacheValue.getValue();
        }
        return null;
    }


}
