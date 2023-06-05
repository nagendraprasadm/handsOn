package org.nm.lc.medium;

/**
 * RETRY
 */
public class RemoveDupLetters316
{
    public String removeDuplicateLetters(String s) {
        int[] alpha = new int[26];
        int start = alpha.length;
        for(int i = 0; i < s.length(); i++){
            alpha[s.charAt(i) - 'a'] = 1;
            start = Math.min(start, s.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        int j = s.indexOf((char)(start+'a'));
        sb.append(s.charAt(j++));
        alpha[start] = 0;
        while(j < s.length()){
            char ic = s.charAt(j);
            if(alpha[ic - 'a'] == 1){
                sb.append(ic);
                alpha[ic - 'a'] = 0;
            }
            j++;
        }

        return sb.toString();
    }
}
