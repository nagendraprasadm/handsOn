package org.nm.util;

import junit.framework.TestCase;
import org.junit.Test;

public class ListUtilTest extends TestCase
{

    @Test
    public void testEmpty(){
        assertEquals(true, ListUtil.checkExists(null, "bla"));
    }
}