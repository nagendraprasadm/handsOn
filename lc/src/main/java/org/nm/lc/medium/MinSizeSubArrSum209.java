package org.nm.lc.medium;

public class MinSizeSubArrSum209
{
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0; int e = 0; int sum = 0;
        int min = Integer.MAX_VALUE;
        while(e < nums.length){
            sum += nums[e];
            while(sum >= target && s >= 0 && s < nums.length){
                min = Math.min(min, e - s + 1);
                sum -= nums[s++];
            }
            e++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
