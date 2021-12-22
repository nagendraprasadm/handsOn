package org.nm.lc.easy;

import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOf2Arrays349
{
    public int[] intersectionWorking4ms(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ix1 = 0;
        int ix2 = 0;
        int ix3 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] res = new int[l1 > l2 ? l2 : l1];
        while (ix1 < l1 && ix2 < l2) {
            int val1 = nums1[ix1];
            int val2 = nums2[ix2];
            if (val1 < val2) {
                ix1++;
                while (ix1 < l1 && nums1[ix1] == val1) {
                    ix1++;
                }
            }
            else if (val1 > val2) {
                ix2++;
                while (ix2 < l2 && nums2[ix2] == val2) {
                    ix2++;
                }
            }
            else {
                res[ix3++] = val1;
                ix1++;
                while (ix1 < l1 && nums1[ix1] == val1) {
                    ix1++;
                }
                ix2++;
                while (ix2 < l2 && nums2[ix2] == val2) {
                    ix2++;
                }
            }
        }

        return Arrays.copyOfRange(res, 0, ix3);
    }

    public int[] intersectionWorking4msVer1(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ix1 = 0;
        int ix2 = 0;
        int ix3 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] res = new int[l1 > l2 ? l2 : l1];
        while (ix1 < l1 && ix2 < l2) {
            int val1 = nums1[ix1];
            int val2 = nums2[ix2];
            if (val1 < val2) {
                ix1++;
                while (ix1 < l1 && nums1[ix1] == val1) {
                    ix1++;
                }
            }
            else if (val1 > val2) {
                ix2++;
                System.out.println("BEFORE LOOP : ix2 -> " + ix2 + ", Value - " + nums2[ix2] + ", and Value 2 -> " + val2);
                while (ix2 < l2 && nums2[ix2] == val2) {
                    System.out.println("ix2 -> " + ix2 + ", Value - " + nums2[ix2]+ ", and Value 2 -> " + val2);
                    ix2++;
                }
            }
            else {
                res[ix3++] = val1;
                ix1++;
                while (ix1 < l1 && nums1[ix1] == val1) {
                    ix1++;
                }
                ix2++;
                while (ix2 < l2 && nums2[ix2] == val2) {
                    ix2++;
                }
            }
        }

        return Arrays.copyOfRange(res, 0, ix3);
    }
}
