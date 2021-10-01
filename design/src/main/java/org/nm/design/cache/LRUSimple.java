package org.nm.design.cache;

import org.nm.design.pattern.iterator.CustomIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Use cases:
 * - For a given key, we should be able to store a value
 * - For a given key we should be able to get value
 * - There is a capacity for the cache. Maximum no of elements it can hold.
 * - If there no of elements cross that cache, then one of them will be evicted.
 * - How will they be evicted.
 * - every a cache item is accessed its weightage increases.
 * - When the cache becomes full to limit, the item with least weightage will
 * be evicted.
 *
 * @param <K> Key Type of the cache
 * @param <V> Value Type in the cache
 */

public class LRUSimple<K, V> implements Cache<K, V>
{
    private static final Logger logger = LoggerFactory.getLogger(LRUSimple.class);

    private int capacity;

    //To maintain the keys in desc order of weight.
    private Deque<K> weightedKeys = new LinkedList<>();

    //Holding Key Value pair of the elements.
    private Map<K, V> data = new HashMap<>();

    public LRUSimple (int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public void put (K key, V value) throws CacheException
    {
        if(key == null || value == null){
            throw new CacheException("Key and Value cannot be null");
        }
        if (data.size() >= capacity) {
            logger.info("Cache has reached capacity evicting least recently used.");
            evict();
        }
        weightedKeys.addFirst(key);
        data.put(key, value);
    }

    @Override
    public V get (K key) throws CacheException
    {
        if(key == null){
            throw new CacheException("Key cannot be null");
        }
        if (data.containsKey(key)) {
            prioritize(key);
            return data.get(key);
        }
        return null;
    }

    @Override
    public List<K> getItems ()
    {
        List<K> keys = new LinkedList<>();
        for(K key : weightedKeys){
            keys.add(key);
        }
        return keys;
    }

    private void evict ()
    {
        K toBeEvictedKey = weightedKeys.getLast();
        logger.info("Key being evicted - {}", toBeEvictedKey);
        weightedKeys.removeLast();
        data.remove(toBeEvictedKey);
    }

    private void prioritize (K key)
    {
        weightedKeys.remove(key);
        weightedKeys.addFirst(key);
    }

    @Override
    public Iterator iterator ()
    {
        return new CustomIterator(this);
    }
}
