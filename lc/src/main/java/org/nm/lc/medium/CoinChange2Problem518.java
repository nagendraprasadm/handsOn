package org.nm.lc.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO : RETRY
 */
public class CoinChange2Problem518
{

    private Map<Integer, Integer> dp = new HashMap<>();

    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(dp.containsKey(amount)){
            return dp.get(amount);
        }
        int cnt = 0;
        Set<Integer> considered = new HashSet<>();
        for(int coin: coins){
            if(!considered.contains(amount - coin)){
                cnt += change(amount - coin, coins);
                considered.add(coin);
            }
        }
        dp.put(amount, cnt);
        return cnt;
    }

    public void resetTrack() {
        dp.clear();
    }
}
