package org.nm.lc.easy;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage2325
{
    public String decodeMessage(String key, String message) {
        Map<Character, Integer> charToIx = new HashMap<>();
        int cnt = 0;
        for(char cur : key.toCharArray()){
            if(cur != ' ' && !charToIx.containsKey(cur)){
                charToIx.put(cur, cnt++);
            }
            if(cnt == 26){
                break;
            }
        }
        char[] res = new char[message.length()];
        int i = 0;
        for(char cur : message.toCharArray()){
            if(cur == ' '){
                res[i++] = cur;
            }else{
                int ix = charToIx.get(cur);
                res[i++] = (char)(97 + charToIx.get(cur));
            }
        }
        return new String(res);
    }
}
