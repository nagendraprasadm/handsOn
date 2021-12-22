package org.nm.lc.easy;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery303
{
    class NumArray {

        //private int[] nums;

        private int[][] sumLeft;

        //private int[] sumRight;

        private int length;

        private int totalSum = 0;

        public NumArray(int[] nums) {
            //this.nums = nums;
            this.length = nums.length;
            this.sumLeft = new int[length][2];
            //this.sumRight = new int[length];
            sumLeft[0][0] = 0;
            sumLeft[length - 1][1] = 0;
            //sumRight[length - 1] = 0;
            for(int i = 0; i < length; i++){
                totalSum += nums[i];
                if(i > 0){
                    sumLeft[i][0] = nums[i-1] +  sumLeft[i-1][0];
                    sumLeft[length - 1 - i][1] = nums[length - i] +  sumLeft[length - i][1];
                }
            }
        /*sumLeft[0] = 0;
        sumRight[length - 1] = 0;
        for(int i = 1; i < length ; i++){
            sumLeft[i] = nums[i-1] +  sumLeft[i-1];
            sumRight[length - 1 - i] = nums[length - i] +  sumRight[length - i];
        }
        for(int i = length - 2; i >= 0 ; i--){
            sumRight[i] = nums[i+1] +  sumRight[i+1];
        }*/
        }

        public int sumRange(int left, int right) {

            return totalSum - sumLeft[left][0] - sumLeft[right][1];

        }
    }
}
