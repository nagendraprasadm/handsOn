package org.nm.lc.easy;

public class ProductArrayExclSelf238
{
    public int[] productExceptSelf (int[] nums)
    {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - 1 - i] = right[len - i] * nums[len - i];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * Left and right - 2 are not required.
     * It can be managed with One array and a variable.
     * @param nums
     * @return
     */
    public int[] productExceptSelfTwo (int[] nums)
    {
        int len = nums.length;
        int[] left = new int[len];
        left[0] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int right = nums[len -1];
        for (int i = len - 2; i >= 0; i--) {
            left[i] = left[i] * right;
            right = right * nums[i];
        }
        return left;
    }
}
