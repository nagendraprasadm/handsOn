package org.nm.lc.easy;

import java.util.Arrays;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes485
{
    public int findMaxConsecutiveOnes (int[] nums)
    {
        //Arrays.sort(nums);
        int ln = nums.length;
        int i = 0;
        int max = 0;
        while (i < ln) {
            int cur = nums[i];
            if (cur == 0) {
                i++;
                while (i < ln && nums[i] == cur) {
                    i++;
                }
            }
            else {
                int s = i;
                i++;
                while (i < ln && nums[i] == cur) {
                    i++;
                }
                max = Math.max(max, i - s);
            }
        }
        return max;
    }
}
