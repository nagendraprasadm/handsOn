package org.nm.common;

public class NumberUtil
{

    public static int findSecondMax(int[] nums){
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max2 = max;
                max = nums[i];
            }else if(nums[i] < max && nums[i] > max2){
                max2 = nums[i];
            }
        }
        return max2;
    }
}
