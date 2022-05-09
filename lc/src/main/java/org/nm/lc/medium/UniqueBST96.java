package org.nm.lc.medium;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueBST96
{
    private static final Logger logger = LoggerFactory.getLogger(UniqueBST96.class);

    public int numTrees(int n) {
        int cnt = 0;
        for(int i = 1; i <= n ; i++){
            int prevcnt = cnt;
            cnt += rec(i, 1, i-1, i+1, n, 1, n, 1);
            logger.info(" No of trees formed with root as - {} is - {} ", i, cnt - prevcnt);
        }
        return cnt;
    }

    public int rec(int ix, int ls, int le, int rs, int re, int cnt, int expcnt, int lvl)
    {
        if (expcnt == cnt) {
            return 1;
        }
        else {
            int ltc = 0;
            if(le == ls){
                ltc = 1;
                cnt += 1;
            }
            else if(le - ls > 0){
                int i = ls;
                while (i <= le) {
                    ltc += rec(i, ls, i - 1, i + 1, le, cnt + 1, expcnt, lvl + 1);
                    i++;
                }
                cnt += le - ls + 1;
            }

            logger.debug("{} Index - {} Left Start - {}, Left End - {}, Left Count - {}", StringUtil.getHyphens(lvl), ix, ls, le, ltc);
            int rtc = 0;
            if(re  == rs){
                rtc += 1;
                cnt += 1;
            }
            else if(re - rs > 0){
                int i = rs;
                while (i <= re){
                    rtc += rec(i, rs, i - 1, i + 1, re, cnt + 1, expcnt, lvl + 1);
                    i++;
                }
            }

            logger.debug("{} Index - {} Right Start - {}, Right End - {}, Right Count - {}", StringUtil.getHyphens(lvl), ix, rs, re, rtc);
            ltc = ltc == 0 ? 1 : ltc;
            rtc = rtc == 0 ? 1 : rtc;
            return ltc * rtc;
        }
    }

}
