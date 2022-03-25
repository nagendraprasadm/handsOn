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
}
