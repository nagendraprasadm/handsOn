package org.nm.lc.medium;

public class SubArrayProductLessThanK713
{
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for(int cnt = 1; cnt <= nums.length; cnt++){
            int s = 0; int e = s + cnt - 1;
            int pr = 1;
            int i = s;
            while(i <= e){
                pr *= nums[i++];
            }
            while(true){
                if (pr < k)
                    res++;
                if(e == nums.length - 1)
                    break;
                if(e < nums.length - 1){
                    pr /= nums[s++];
                    pr *= nums[++e];
                }
            }
        }
        return res;
    }
}
