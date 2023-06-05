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

    @Test
    public void testOneInPlace() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        inst.mergeInPlace(nums1, 3, nums2, 3);
        assertEquals(nums1[3],3);
    }

    @Test
    public void testTwoInPlace() {
        int[] nums1 = new int[]{1,3,5,7,9,0,0,0};
        int[] nums2 = new int[]{2,8,10};
        inst.mergeInPlace(nums1, 5, nums2, 3);
        assertEquals(nums1[4],7);
    }

    @Test
    public void testThreeInPlace() {
        int[] nums1 = new int[]{2,8,10,0,0,0,0,0};
        int[] nums2 = new int[]{1,3,5,7,9};
        inst.mergeInPlace(nums1, 3, nums2, 5);
        assertEquals(nums1[4],7);
    }
}