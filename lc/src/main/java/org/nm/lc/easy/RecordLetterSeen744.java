package org.nm.lc.easy;

public class RecordLetterSeen744
{
    public char nextGreatestLetter(char[] letters, char target) {
        int[] chrs = new int[26];
        for(int i = 0; i < letters.length; i++){
            int ix = letters[i] - 'a';
            chrs[ix] = ++chrs[ix];
        }
        //int i = target - 'a';
        while(true){
            target++;
            if(target > 'z') target = 0;
            if(chrs[target - 'a'] > 0){
                return target;
            }
        }

    }
}
