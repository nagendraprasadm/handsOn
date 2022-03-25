package org.nm.lc.easy;

public class ImplementStrstr28
{
    public int strStr (String haystack, String needle)
    {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        else {
            int ix = -1;
            int i = 0;
            int j = 0;
            while (i < haystack.length() && j < needle.length()) {
                int hayc = haystack.charAt(i);
                int nec = needle.charAt(j);
                if (hayc == nec) {
                    if (j == 0) {
                        ix = i;
                    }
                    j++;
                    i++;
                }
                else {
                    j = 0;
                    if (ix > -1) {
                        i = ix + 1;
                    }
                    else {
                        i = i + 1;
                    }
                    ix = -1;
                }
            }
            return j == needle.length() ? ix : -1;
        }
    }
}
