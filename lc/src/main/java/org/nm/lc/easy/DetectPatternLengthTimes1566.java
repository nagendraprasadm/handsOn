package org.nm.lc.easy;

import java.util.*;

public class DetectPatternLengthTimes1566
{
    public boolean containsPattern (int[] arr, int m, int k)
    {
        Map<String, List<Integer>> trk = new HashMap<>();
        int l = arr.length;
        for (int i = 0; i <= l - m; i++) {
            int[] suba = Arrays.copyOfRange(arr, i, i + m);
            String str = Arrays.toString(suba);
            if (trk.containsKey(str)) {
                List<Integer> ixs = trk.get(str);
                ixs.add(i);
                trk.put(str, ixs);
            }
            else {
                List<Integer> ixs = new ArrayList<>();
                ixs.add(i);
                trk.put(str, ixs);
            }
        }

        Set<String> keys = trk.keySet();
        for (String key : keys) {
            List<Integer> val = trk.get(key);
            if (val.size() >= k) {
                int prev = val.get(0);
                int cnt = 1;
                for (int i = 1; i < val.size(); i++) {
                    int cur = val.get(i);
                    if (prev + m == cur) {
                        cnt++;
                    }
                    else if (prev + m > cur) {
                        continue;
                    }
                    else {
                        cnt = 1;
                    }
                    if (cnt >= k) {
                        return true;
                    }
                    prev = cur;
                }
            }
        }
        return false;
    }
}
