package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatDNASequences187
{
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() >= 10){
            Map<String, Integer> trk = new HashMap<>();
            trk.put(s.substring(0, 10), 1);
            for(int i = 1; i < s.length() - 9; i++){
                String cur = s.substring(i, i+10);
                trk.put(cur, trk.getOrDefault(cur, 0) + 1);
            }
            for(String key : trk.keySet()){
                int cnt = trk.get(key);
                if(cnt > 1){
                    res.add(key);
                }
            }
        }
        return res;
    }
}
