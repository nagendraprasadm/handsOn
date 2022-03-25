package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MultiplyStrings43Test extends TestCase
{
    MultiplyStrings43 inst = new MultiplyStrings43();

    @Test
    public void testone() {
        String res = inst.multiply("21", "3");
        assertEquals("63", res);
    }

    @Test
    public void test2(){
        String res = inst.multiply("68", "39");
        assertEquals("2652", res);
    }

    @Test
    public void test3(){
        String res = inst.multiply("699", "599");
        assertEquals("2652", res);
    }

    @Test
    public void test4(){
        String res = inst.multiply("9", "9");
        assertEquals("81", res);
    }
}