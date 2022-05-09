package org.nm.lc.hard;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditDistance
{
    private static final Logger logger = LoggerFactory.getLogger(EditDistance.class);

    public int editDistance(String w1, String w2){
        //Replace, Insert, Delete
        //int[][] dp = new int[w1.length()][3];
        //return recNOCache(0,0,w1, w2, 0, 1);
       return rec(0,0,w1, w2, 0,new Integer[w1.length()][w2.length()]);
        //return match(w1.toCharArray(), w2.toCharArray(), 0,0, new Integer[w1.length()][w2.length()], 1);
        //return rec2(0,0,w1, w2, new Integer[w1.length()][w2.length()]);
    }


    private int match(char[] c1, char[] c2, int i, int j, Integer[][] cache,int  lvl) {
        if (c1.length == i) return c2.length - j;
        if (c2.length == j) return c1.length - i;

        if (cache[i][j] != null) {
            logger.info(" {} i - {}, j - {}, w1 char - {}, w2 char - {}, distance CACHE- {}",
                        StringUtil.getHyphens(lvl), i , j , c1[i], c2[j], cache[i][j]);
            return cache[i][j];
        }

        if (c1[i] == c2[j]) {
            cache[i][j] = match(c1, c2, i + 1, j + 1, cache, lvl + 1);
            logger.info(" {} i - {}, j - {}, w1 char - {}, w2 char - {}, distance - {}",
                        StringUtil.getHyphens(lvl), i , j , c1[i], c2[j], cache[i][j]);
        } else {
            //Case1: insert
            int insert = match(c1, c2, i, j + 1, cache, lvl + 1);
            //Case2: delete
            int delete = match(c1, c2, i + 1, j, cache, lvl + 1);
            //Case3: replace
            int replace = match(c1, c2, i + 1, j + 1, cache, lvl + 1);

            cache[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
            logger.info(" {} i - {}, j - {}, w1 char - {}, w2 char - {}, distance - {}, distances - {}, {}, {}",
                        StringUtil.getHyphens(lvl), i , j , c1[i], c2[j], cache[i][j], delete, insert, replace);

        }

        return cache[i][j];
    }
    private int rec(int i, int j, String w1, String w2, int cnt, Integer[][] cache){
        if(i < w1.length() && j < w2.length()){
            if(cache[i][j] != null){
                return cnt + cache[i][j];
            }
            if(w1.charAt(i) == w2.charAt(j)){
               int res =  rec(i + 1, j + 1, w1, w2, cnt,cache);
               cache[i][j] = res - cnt;
               return res;
            }else{
                //Delete
                int dc = rec(i + 1, j, w1, w2, cnt + 1, cache);
                //Insert
                int di = rec(i, j+ 1, w1, w2, cnt + 1, cache);
                //Replace
                int dr = rec(i+1, j+ 1, w1, w2, cnt + 1, cache);

                int res = Math.min(Math.min(di,dc), dr);
                cache[i][j] = res - cnt;
                return res;
            }
        }else if(i == w1.length() && j < w2.length()){
            int diff = w2.length() - j;
            return cnt + diff;
        }else if (j == w2.length() && i < w1.length()){
            int diff = w1.length() - i;
            return cnt + diff;
        }
        return cnt;
    }

    private int recNOCache(int i, int j, String w1, String w2, int cnt, int lvl){
        if(i < w1.length() && j < w2.length()){
            if(w1.charAt(i) == w2.charAt(j)){
                int res = recNOCache(i + 1, j + 1, w1, w2, cnt, lvl + 1);
                return res;
            }else{
                //Delete
                int dc = recNOCache(i + 1, j, w1, w2, cnt + 1, lvl + 1);
                //Insert
                int di = recNOCache(i, j+ 1, w1, w2, cnt + 1, lvl + 1);
                //Replace
                int dr = recNOCache(i+1, j+ 1, w1, w2, cnt + 1, lvl + 1);
                int res = Math.min(Math.min(di,dc), dr);
                return res;

            }
        }else if(i == w1.length() && j < w2.length()){
            int diff = w2.length() - j;
            return cnt + diff;
        }else if (j == w2.length() && i < w1.length()){
            int diff = w1.length() - i;
            return cnt + diff;
        }
        return cnt;
    }

    private int rec2(int i, int j, String w1, String w2, Integer[][] cache){
        if(i < w1.length() && j < w2.length()){
            if(cache[i][j] != null){
                return cache[i][j];
            }
            if(w1.charAt(i) == w2.charAt(j)){
                cache[i][j] =  rec2(i + 1, j + 1, w1, w2,cache);
            }else{
                //Delete
                int dc = rec2(i + 1, j, w1, w2,  cache);
                //Insert
                int di = rec2(i, j+ 1, w1, w2, cache);
                //Replace
                int dr = rec2(i+1, j+ 1, w1, w2, cache);
                cache[i][j] = Math.min(Math.min(di,dc), dr);
            }
            return cache[i][j];
        }else if(i == w1.length() && j < w2.length()){
            return w2.length() - j;

        }else if (j == w2.length() && i < w1.length()){
            return w1.length() - i;
        }
        return 0;
    }
}
