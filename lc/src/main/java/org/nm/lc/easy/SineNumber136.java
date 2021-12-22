package org.nm.lc.easy;

import java.util.HashMap;
import java.util.Map;

public class SineNumber136
{
    public int singleNumber (int[] nums)
    {
        Map<Integer, Integer> valueToIx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valueToIx.containsKey(nums[i])) {
                nums[i] = Integer.MIN_VALUE;
                nums[valueToIx.get(val)] = Integer.MIN_VALUE;
            }
            else {
                valueToIx.put(val, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                return nums[i];
            }
        }

        return -1;
    }
}
