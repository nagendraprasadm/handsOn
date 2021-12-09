package org.nm.lc.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix14
{
    public String longestCommonPrefix (String[] strs)
    {
        int maxPrefixLength = Integer.MAX_VALUE;
        String pref = "";
        int init = 0;
        for (int i = 0; i < strs.length; i++) {
            if (maxPrefixLength > strs[i].length()) {
                maxPrefixLength = strs[i].length();
                pref = strs[i];
                init = i;
            }
        }
        if (maxPrefixLength > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (init != i) {
                    String cur = strs[i];
                    for (int j = 1; j <= maxPrefixLength; j++) {
                        if (cur.charAt(j - 1) != pref.charAt(j - 1)) {
                            maxPrefixLength = j - 1;
                            pref = cur.substring(0, maxPrefixLength);
                        }
                    }
                    if (maxPrefixLength == 0) {
                        break;
                    }
                }
            }
        }
        return pref;
    }
}
