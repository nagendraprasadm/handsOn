package org.nm.lc.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ThirdMaximumNumber414
{
    public int thirdMax (int[] nums)
    {
        Arrays.sort(nums);
        int i = nums.length - 1;
        int cnt = 0;
        while (i >= 0) {
            int prev = nums[i];
            i--;
            while (i >= 0 && nums[i] == prev) {
                i--;
            }
            cnt++;
            if (cnt == 3) {
                return prev;
            }
        }
        return nums[nums.length - 1];
    }

}
