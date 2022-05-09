package org.nm.lc.medium;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * RETRY
 */
///TODO : A better approach
public class CoinChange322
{
    private Logger logger = LoggerFactory.getLogger(CoinChange322.class);

    private Map<Integer, Integer> trk = new HashMap<>();
    private int minop = Integer.MAX_VALUE;

    public int coinChange (int[] coins, int amount)
    {
        Arrays.sort(coins);
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int no = rec(i, coins, amount, 1);
            if (no > -1) {
                min = Math.min(min, no);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int rec (int i, int[] coins, int target, int lvl)
    {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return -1;
        }
        if (i >= 0 && i < coins.length) {
            //String key = i + "-" + target;
            if(trk.containsKey(target)){
                return trk.get(target);
            }
            int cur = coins[i];
            int q = target / cur;
            int mcnt = Integer.MAX_VALUE;
            for (int j = q; j >= 0; j--) {
                int cnt = rec(i - 1, coins, target - (cur * j), lvl + 1);

                if (cnt > -1) {
                    mcnt = Math.min(cnt + j, mcnt);
                    if(cnt  == 0){
                        minop = Math.min(minop, mcnt);
                    }
                }
                if(cnt > -1 || mcnt < Integer.MAX_VALUE){

                    logger.info(
                        "{} i - {}, Cur Value - {}, target - {},  quotient - {}, j - {}, cnt - {} and min cnt - {}",
                        StringUtil.getHyphens(lvl), i, cur,target, q, j, cnt, mcnt);
                }
            }
            trk.put(target, mcnt == Integer.MAX_VALUE ? -1 : mcnt) ;
            return trk.get(target);
        }
        return -1;
    }
}