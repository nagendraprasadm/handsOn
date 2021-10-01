package org.nm.design.cache;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class LRUSimpleTest
{
    private static final Logger logger = LoggerFactory.getLogger(LRUSimpleTest.class);

    @Rule
    public TestName name = new TestName();

    @Test
    public void testSimple () throws Exception
    {
        Cache<String, Integer> cache = new LRUSimple<>(2);
        cache.put("First", 1);
        cache.put("Second", 2);
        logKeys(cache);
        cache.put("Third", 3);
        logKeys(cache);
        Assert.assertEquals((Integer)2, cache.get("Second"));
        logKeys(cache);
        cache.put("Fourth", 4);
        logKeys(cache);
    }

    private void logKeys(Cache cache) {
        Iterator itr = cache.iterator();
        StringBuilder builder = new StringBuilder();
        while(itr.hasNext()){
            Object key = itr.next();
            builder.append(key + "->");
        }
        logger.info("{} - Keys are - {}", name.getMethodName(), builder.toString());
    }

}