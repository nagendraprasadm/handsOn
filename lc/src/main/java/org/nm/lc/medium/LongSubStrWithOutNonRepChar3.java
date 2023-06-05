package org.nm.lc.medium;

import java.util.HashMap;
import java.util.Map;

public class LongSubStrWithOutNonRepChar3
{

    public int lengthOfLongestSubstring (String s)
    {
        if (s.length() > 0) {
            Map<Character, Integer> trk = new HashMap<>();
            int max = 1;
            int st = 0;
            int i = 0;
            trk.put(s.charAt(i++), 0);
            while (i < s.length()) {
                char cur = s.charAt(i);
                if (trk.containsKey(cur) && trk.get(cur) >= st) {
                    st = trk.get(cur)  + 1;
                }
                else {
                    max = Math.max(i - st + 1, max);
                }
                trk.put(cur, i);
                i++;
            }
            return max;
        }
        return 0;
    }

    public int lengthOfLongestSubstringv2(String s) {
        int st = 0;
        int ln = 0;
        Map<Character, Integer> trk = new HashMap<>();
        trk.put(s.charAt(0), 0);
        for(int i = 1; i < s.length() ; i++){
            if(trk.containsKey(s.charAt(i)) && trk.get(s.charAt(i)) > st){
                ln = Math.max(ln, i - st);
                st = trk.get(s.charAt(i)) + 1;
            }
            trk.put(s.charAt(i), i);
        }
        ln = Math.max(ln, s.length() - st);
        return ln;

    }

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> trk = new HashMap<>();
        int st = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(trk.containsKey(c)){
                max = Math.max(max, i-st);
                st = Math.max(trk.get(c) + 1, st);
            }
            trk.put(c, i);
        }
        return Math.max(max, s.length() - st);
    }
}
