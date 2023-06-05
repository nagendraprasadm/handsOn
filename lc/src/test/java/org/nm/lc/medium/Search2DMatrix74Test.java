package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class Search2DMatrix74Test extends TestCase
{
    private Search2DMatrix74 inst = new Search2DMatrix74();

    @Test
    public void testOne(){
        int[][] input = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        assertTrue(inst.searchMatrix(input, 10));
    }

}