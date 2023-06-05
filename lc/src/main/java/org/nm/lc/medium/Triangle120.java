package org.nm.lc.medium;

import java.util.Arrays;
import java.util.List;

public class Triangle120
{
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] rsum = new int[len];
        Arrays.fill(rsum, Integer.MAX_VALUE);
        rsum[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; i++){
            int[] nsum = new int[len];
            Arrays.fill(nsum, Integer.MAX_VALUE);
            for(int j = 0; j < i; j++){
                nsum[j] = Math.min(nsum[j], rsum[j] + triangle.get(i).get(j));
                nsum[j+1] = Math.min(nsum[j+1], rsum[j] + triangle.get(i).get(j+1));
            }
            rsum = nsum;
        }
        int mins = Integer.MAX_VALUE;
        for(int s : rsum){
            mins = Math.min(s, mins);
        }
        return mins;
    }
}
