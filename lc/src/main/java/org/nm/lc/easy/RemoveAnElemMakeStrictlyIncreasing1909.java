package org.nm.lc.easy;

/**
 * Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one element, or false otherwise. If the array is already strictly increasing, return true.
 *
 * The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,10,5,7]
 * Output: true
 * Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
 * [1,2,5,7] is strictly increasing, so return true.
 * Example 2:
 *
 * Input: nums = [2,3,1,2]
 * Output: false
 * Explanation:
 * [3,1,2] is the result of removing the element at index 0.
 * [2,1,2] is the result of removing the element at index 1.
 * [2,3,2] is the result of removing the element at index 2.
 * [2,3,1] is the result of removing the element at index 3.
 * No resulting array is strictly increasing, so return false.
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: false
 * Explanation: The result of removing any element is [1,1].
 * [1,1] is not strictly increasing, so return false.
 */
public class RemoveAnElemMakeStrictlyIncreasing1909
{
    public boolean canBeIncreasing(int[] nums) {
        return recurCheck(nums, 0, nums.length - 1, 0);
    }

    private boolean recurCheck(int[] nums, int s, int e, int cnt)
    {
        int ix = s + 1;
        while (ix <= e) {
            if (nums[ix - 1] >= nums[ix]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                boolean skipprev = ix - 2 >= 0 ? nums[ix - 2] < nums[ix] : true;
                boolean skipcur = ix + 1 <= e ? nums[ix - 1] < nums[ix + 1] : true;
                return (skipprev && recurCheck(nums, ix, e, cnt)) || (
                    recurCheck(nums, ix + 1, e, cnt) && skipcur);
            }
            ix++;
        }
        return true;
    }
}
