package org.nm.lc.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray697
{
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer[]> cnt = new HashMap<>();
        int maxCnt = 1;
        for(int i = 0; i < nums.length; i++){
            if(cnt.containsKey(nums[i])){
                Integer[] trk = cnt.get(nums[i]);
                trk[1] = i;
                trk[2] = ++trk[2];
                maxCnt = Math.max(maxCnt, trk[2]);
            }else{
                cnt.put(nums[i], new Integer[]{i, i, 1});
            }
        }

        int minSpan = nums.length;
        for(Integer elem : cnt.keySet()){
            Integer[] value = cnt.get(elem);
            if(value[2] == maxCnt){
                minSpan = Math.min(minSpan, value[1] - value[0] + 1);
            }
        }
        return minSpan;
    }
}
