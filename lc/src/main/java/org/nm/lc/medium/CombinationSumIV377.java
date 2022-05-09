package org.nm.lc.medium;

public class CombinationSumIV377
{
    public int combinationSum4(int[] nums, int target) {
        int[][] dp =new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }
        for(int j = 1; j <= target; j++){
            for(int i = 1; i <= nums.length; i++){
                int num = nums[i-1];
                if(j < num){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[nums.length][j - num];
                }
            }
        }
        return dp[nums.length][target];
    }
}
