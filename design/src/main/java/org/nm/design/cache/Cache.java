package org.nm.design.cache;

import org.nm.design.pattern.iterator.CustomIterable;

import java.util.List;

public interface Cache<K,V> extends CustomIterable<K>
{
    void put(K key, V value) throws CacheException;

    V get(K key) throws CacheException;

}
