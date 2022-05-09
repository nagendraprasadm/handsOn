package org.nm.lc.medium;

import java.util.HashMap;
import java.util.Map;

public class LongPalindromeSubSequence516
{
    public int longestPalindromeSubseq(String s) {
        int ml = 0;
        Map<String, Integer> trk = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int l1 = rec3(i-1, i+1, s, 1, trk);
            int l2 = rec3(i, i+1, s, 0, trk);
            l1 = Math.max(l1,l2);
            ml = Math.max(l1, ml);
        }
        return ml;
    }

    private int rec3(int lt, int rt, String s, int ln, Map<String, Integer> trk){
        if(lt < 0 || rt >= s.length()){
            return ln;
        }
        String key = lt + "-" + rt;
        if(!trk.containsKey(key)){
            while(lt >= 0 && rt < s.length()){
                if(s.charAt(lt) == s.charAt(rt)){
                    lt--;
                    rt++;
                    ln += rec3(lt, rt, s, ln, trk) + 2;
                }else{
                    ln = Math.max(rec3(lt-1, rt, s, ln, trk), rec3(lt, rt+1, s, ln, trk));
                    break;
                }
            }
            trk.put(key, ln);
            return trk.get(key);
        }
        return trk.get(key);
    }
}
