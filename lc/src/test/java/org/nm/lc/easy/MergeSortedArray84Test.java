package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArray84Test
{
    MergeSortedArray84 inst = new MergeSortedArray84();

    @Test
    public void testOne() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        inst.merge(nums1, 3, nums2, 3);
        assertEquals(nums1[3],3);
    }
}