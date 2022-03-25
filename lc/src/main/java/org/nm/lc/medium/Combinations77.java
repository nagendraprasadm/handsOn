package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations77
{
    public List<List<Integer>> combine (int n, int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 1) {
            return combine(1, n, k);
        }
        for (int i = 1; i <= n - k + 1; i++) {
            List<List<Integer>> temp = combine(i, n, k);
            res.addAll(temp);
        }
        return res;
    }

    private List<List<Integer>> combine (int s, int n, int k)
    {
        if (s + k - 1 > n) {
            return new ArrayList<>();
        }
        else if (k == 1) {
            List<List<Integer>> res = new ArrayList<>();

            for (int i = s; i <= n; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                res.add(temp);
            }

            return res;
        }
        else {
            List<List<Integer>> res = new ArrayList<>();
            if(k == 2){
                for(int i = s + 1; i<= n ; i++){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(s);
                    temp.add(i);
                    res.add(temp);
                }
            }else{
                for(int i = s + 1; i<= n -k +2 ; i++){
                    List<List<Integer>> prev = combine(i, n, k-1);
                    if(prev != null && prev.size() > 0){
                        for(int j = 0; j < prev.size(); j++){
                            List<Integer> temp = prev.get(j);
                            temp.add(s);
                            res.add(temp);
                        }
                    }
                }
            }

            return res;
        }

    }
}
