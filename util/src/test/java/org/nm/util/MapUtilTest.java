package org.nm.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilTest extends TestCase
{

    @Test
    public void testNullIntoMap() {
        Map<String, String> testMap = new HashMap<>();
        MapUtil.putNULLValueIntoMap(testMap, "Test");
        assertEquals(1, testMap.size());
        MapUtil.putNULLValueIntoMap(testMap, null);
        assertEquals(2, testMap.size());
    }
}