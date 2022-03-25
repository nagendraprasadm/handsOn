package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations46
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutate(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private List<Integer> permutate(int pos, int[] nums, List<List<Integer>> res, List<Integer> curR) {
        if(pos == nums.length){
            res.add(new ArrayList<>(curR));
        }else{
            for(int i = 0; i < nums.length; i++){
                int curval = nums[i];
                if(curval != -20){
                    nums[i] = -20;
                    curR.add(curval);
                    curR = permutate(pos + 1, nums, res, curR);
                    curR.remove((Integer)curval);
                    nums[i] = curval;
                }
            }
        }
        return curR;
    }
}
