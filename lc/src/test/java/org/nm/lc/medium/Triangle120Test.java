package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.common.ListUtil;

import java.util.List;

public class Triangle120Test extends TestCase
{
    private Triangle120 inst = new Triangle120();

    @Test
    public void testone() {
        List<List<Integer>> inp = ListUtil.fromString2D("[[2],[3,4],[6,5,7],[4,1,8,3]]");
        assertEquals(11, inst.minimumTotal(inp));
    }

}