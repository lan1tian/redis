package com.lantian.redis.lfu;

import lombok.Getter;

@Getter
public class CacheValue<V> {

    private final V value;
    private long time;
    private int count;

    public CacheValue(V value) {
        this.value = value;
        this.time = System.nanoTime();
        this.count = 1;
    }

    public int incCount() {
        return ++count;
    }


    @Override
    public String toString() {
        return "CacheValue{" +
                "value=" + value +
                ", time=" + time +
                ", count=" + count +
                '}';
    }
}
