package org.nm.lc.medium;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongPalindSubStr5
{
    private Logger logger = LoggerFactory.getLogger(LongPalindSubStr5.class);

    int f = 0;
    int l = 0;
    int max = 1;

    public String longestPalindromeTLE(String s) {
        int mid = s.length()/2;
        int[][] pal = new int[s.length()][s.length()];
        for(int i = 0; i < s.length() ; i++){
            for(int j = 0; j < s.length() ; j++){
                if(i != j){
                    pal[i][j] = -1;
                }else{
                    pal[i][j] = 1;
                }
            }
        }
        getMax(s, mid, new int[s.length()], pal);
        return s.substring(f, l+1);
    }

    private void getMax(String s, int ix, int[] trk, int[][] pal){
        if(ix >=0 && ix < s.length() && trk[ix] == 0){
            //logger.info("Current index - {}, track - {}", ix, ArrayUtils.toString(trk));
            trk[ix] = 1;
            int lo = ix - 1;
            int hi = ix + 1;

            while(lo >= 0){
                if(check(lo, ix, pal, s)){
                    if((ix - lo + 1) > max){
                        max = ix - lo + 1;
                        f = lo;
                        l = ix;
                    }
                }
                lo--;
            }
            while(hi < s.length()){
                if(check(ix, hi, pal, s)){
                    if((hi - ix + 1) > max){
                        max = hi - ix + 1;
                        f = ix;
                        l = hi;
                    }
                }
                hi++;
            }
            lo = ix - 1;
            hi = ix + 1;
            while(lo >= 0 && hi < s.length()){
                if(check(lo, hi, pal, s)){
                    if(hi - lo + 1 > max){
                        max = hi - lo + 1;
                        f = lo;
                        l = hi;
                    }
                }
                lo--;
                hi++;
            }
            getMax(s, ix - 1, trk, pal);
            getMax(s, ix + 1, trk, pal);
            trk[ix] = 0;
        }
    }

    private boolean check(int s, int e, int[][] pal, String str){
        if(pal[s][e] != -1){
            return pal[s][e] == 1;
        }else{
            if(pal[s+1][e-1] != -1){
                pal[s][e]= (pal[s+1][e-1] == 1 && str.charAt(s) == str.charAt(e)) ? 1 : 0;
            }else{
                logger.info("Checking Palindrome validity Start - {} and end - {}", s, e);
                boolean isPalind = true;
                int lo = s;
                int hi = e;
                while(lo < hi){
                    if(str.charAt(lo) != str.charAt(hi))
                    {
                        isPalind = false;
                        break;
                    }
                    lo++;
                    hi--;
                }
                pal[s][e] = isPalind ? 1 : 0;
            }
            return pal[s][e] == 1;
        }
    }

    public String longestPalindrome(String s) {
        int ml = 0;
        String ms = null;
        for(int i = 0; i < s.length(); i++){
            int l1 = palindromLength1(i, s);
            int l2 = palindromLength2(i, s);
            l1 = Math.max(l1,l2);
            if(l1 > ml){
                ml = l1;
                int st = i - ((l1-1)/2);
                int e = i + (l1/2);
                ms = s.substring(st, e+1);
            }
        }
        return ms;
    }

    private int palindromLength1(int ix, String s){
        int ln = 1;
        int l = ix - 1;
        int r = ix + 1;
        while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)){
            ln += 2;
        }
        return ln;
    }

    private int palindromLength2(int ix, String s){
        int ln = 0;
        int l = ix;
        int r = ix + 1;
        while(l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)){
            ln += 2;
        }
        return ln;
    }
}
