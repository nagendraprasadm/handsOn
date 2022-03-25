package org.nm.lc.medium;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.nm.lc.easy.MergeSortedArray84;

import static org.junit.Assert.*;

public class MergeIntervals56Test
{
    MergeIntervals56 inst = new MergeIntervals56();

    @Test
    public void testone() {
        //int[][] res = inst.merge(new int[][]{{2,3}, {4,5}, {6,7}, {8,9}, {1,10}});
        int[][] res = inst.merge(new int[][]{{2,3}, {4,5},
                                             {2,5 }, {4,6 }});
        System.out.println(ArrayUtils.toString(res));
        //int[][] res = inst.merge(new int[][]{{1,4}, {0,4}});
        //int[][] res = inst.merge(new int[][]{{1,3},{0,2},{2,3},{4,6},{4,5},{5,5},{0,2},{3,3}});
    }
}