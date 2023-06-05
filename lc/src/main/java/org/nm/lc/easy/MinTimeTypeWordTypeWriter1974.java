package org.nm.lc.easy;

public class MinTimeTypeWordTypeWriter1974
{
    public int minTimeToType(String word) {
        int cost = 0;
        char prev = 'a';
        for(int i = 0; i < word.length();i++){
            char cur = word.charAt(i);
            if(prev > cur){
                cost += Math.min(('z' - prev) + cur - 'a' + 1, prev - cur) + 1;
            }else{
                cost += Math.min(cur - prev, prev - 'a' + 1 + ('z' - cur)) + 1;
            }
            prev = cur;
        }
        return cost;
    }
}
