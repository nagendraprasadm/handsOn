package org.nm.lc.easy;

public class FirstUniqueCharacterString387
{
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        int[] ix = new int[26];
        //List<Integer> uniqueOnes = new ArrayList<>();
        for(int i = 0; i < s.length() ; i++) {
            cnt[s.charAt(i) - 'a'] = cnt[s.charAt(i) - 'a'] + 1;
            ix[s.charAt(i) - 'a'] = i;
        }
        int minIx = 27;
        for(int i = 0; i < 26 ; i++){
            if(cnt[i] == 1){
                minIx = Math.min(minIx, ix[i]) ;
            }
        }
        return minIx < 27 ? minIx : -1;
    }
}
