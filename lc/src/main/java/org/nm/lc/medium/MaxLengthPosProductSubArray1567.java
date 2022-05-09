package org.nm.lc.medium;

public class MaxLengthPosProductSubArray1567
{
    public int getMaxLen(int[] nums) {
        long neg = 1;
        long pos = 1;
        int l1 = 0;
        int l2 = 0;
        int i = 0;
        int max = 0;
        while( i < nums.length){
            int val = nums[i];
            if(val > 0){
                if(l1 > 0){
                    neg = neg * val;
                    l1++;
                }
                pos = pos * val;
                l2++;
            }else if (val < 0){
                long cneg = neg;
                int ol1 = l1;
                neg = pos * val;
                l1 = l2 + 1;
                pos = 1;
                if(ol1 > 0){
                    pos = cneg * val;
                    l2 = ol1 + 1;
                }else{
                    l2 = 0;
                }

            }else{
                l1 = 0;
                l2 = 0;
                neg = 1;
                pos = 1;
            }
            max = Math.max(max, l2);
            i++;
        }
        return max;
    }
}
