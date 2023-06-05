package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, List<List<Integer>>> dp = new HashMap<>();

    public List<List<Integer>> combine2(int n, int k) {
        for(int i = 1 ; i <= n; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(i);
            List<List<Integer>> fc = new ArrayList<>();
            fc.add(cur);
            dp.put(getKey(i,1), fc);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            res.addAll(rec(i,k,n));
        }
        return res;
    }

    private List<List<Integer>> rec(int i, int cnt, int n){
        if(dp.containsKey(getKey(i, cnt))){
            return dp.get(getKey(i, cnt));
        }else{
            List<List<Integer>> elems = new ArrayList<>();
            for(int j = i+1; j<= n; j++){
                List<List<Integer>> cur = rec(j, cnt-1,n);
                for(List<Integer> curl : cur){
                    List<Integer> cloned = new ArrayList<>();
                    for(Integer t : curl){
                        cloned.add(t);
                    }
                    elems.add(cloned);
                }
            }

            for(List<Integer> elem : elems){
                elem.add(i);
            }
            dp.put(getKey(i,cnt), elems);
            return elems;
        }
    }

    private String getKey(int i, int cnt){
        return Integer.toString(i) + '#' + Integer.toString(cnt);
    }



    private Map<Integer, Map<Integer, List<List<Integer>>>> cache = new HashMap<>();

    public List<List<Integer>> combineV3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= (n-k+1); i++){
            List<List<Integer>> cur = dp(i, k, n);
            if(cur != null && cur.size() > 0){
                res.addAll(cur);
            }
        }
        return res;
    }

    private List<List<Integer>> dp(int s, int k, int n){
        if(k <= 0){
            return null;
        }
        else if(cache.containsKey(s) && cache.get(s).containsKey(k)){
            return cache.get(s).get(k);
        }else{
            Map<Integer, List<List<Integer>>> curVal = null;
            if(!cache.containsKey(s)){
                curVal = new HashMap<>();
                cache.put(s, curVal);
            }
            curVal = cache.get(s);

            if(k == 1){
                List<List<Integer>> res = new ArrayList<>();
                /*for(int i = s ; i <= n ; i++){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    res.add(cur);
                }*/
                    List<Integer> cur = new ArrayList<>();
                    cur.add(s);
                    res.add(cur);
                curVal.put(k, res);
            }else{
                List<List<Integer>> res = new ArrayList<>();
                for(int i = s + 1; i <=(n - k + 2) ;i++){
                    List<List<Integer>> prevO = dp(i, k-1, n);
                    if(prevO != null){
                        List<List<Integer>> prev = new ArrayList<>(prevO);
                        if(prev.size() > 0){
                            for(int j = 0; j < prev.size(); j++){
                                List<Integer> tmp = new ArrayList<>(prev.get(j));
                                tmp.add(s);
                                res.add(tmp);
                            }
                        }
                    }
                }
                curVal.put(k, res);

            }
            return cache.get(s).get(k);
        }
    }
}
