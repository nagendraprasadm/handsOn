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
}
