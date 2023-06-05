package org.nm.lc.medium;

import java.util.Arrays;

public class PermInString567
{
    public boolean checkInclusion (String s1, String s2)
    {
        int ln = s1.length();
        int s = 0;
        int e = s + ln - 1;
        int[] trk = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            trk[s1.charAt(i) - 'a'] = trk[s1.charAt(i) - 'a'] + 1;
        }
        while (e < s2.length()) {
            char curE = s2.charAt(e);
            char curS = s2.charAt(s);
            if (trk[curE - 'a'] == 0) {
                s = e + 1;
                e = s + ln - 1;
            }
            else if (trk[curS - 'a'] == 0) {
                s++;
                e++;
            }
            else {
                int[] trkc = new int[26];
                System.arraycopy(trk, 0, trkc, 0, 26);
                if (isValid(trkc, s2, s, e)) {
                    return true;
                }
                else {
                    s++;
                    e++;
                }
            }
        }
        return false;
    }

    private boolean isValid (int[] trk, String s2, int s, int e)
    {
        for (int i = s; i <= s; i++) {
            int val = trk[s2.charAt(i) - 'a'] - 1;
            if (val < 0) {
                return false;
            }
            trk[s2.charAt(i) - 'a'] = val;
        }
        return true;
    }

    private boolean isAnagram (char[] s1a, String s2)
    {
        char[] s2a = s2.toCharArray();
        Arrays.sort(s2a);
        if (s1a.length == s2a.length) {
            for (int i = 0; i < s1a.length; i++) {
                if (s1a[i] != s2a[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkInclusionBetter(String s1, String s2) {

        int[] s1trk = new int[26];
        for(int i = 0; i < s1.length() ;i++){
            s1trk[s1.charAt(i) - 'a'] = s1trk[s1.charAt(i) - 'a'] + 1;
        }
        int len = s1.length();
        int[] s2trk = new int[26];
        int count = 0;
        for(int i =0 ;i < s2.length(); i++){
            int c = s2.charAt(i) - 'a';
            if(s1trk[c] > 0){
                s2trk[c] = s2trk[c]+ 1;
                count++;
            }else{
                count = 0;
                Arrays.fill(s2trk, 0);
            }
            if(count == len ){
                if(match(s1trk, s2trk)){
                    return true;
                }else{
                    int cur = s2.charAt(i - len + 1) - 'a';
                    s2trk[cur] = s2trk[cur] > 0 ? s2trk[cur]- 1 : 0;
                    count--;
                }
            }
        }
        return false;
    }

    private boolean match(int[] s1, int[] s2){
        for(int i =0; i < 26; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}
