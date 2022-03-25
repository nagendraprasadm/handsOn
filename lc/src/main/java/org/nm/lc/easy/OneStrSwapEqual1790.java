package org.nm.lc.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 *
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 *
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */
public class OneStrSwapEqual1790
{

    public boolean areAlmostEqual(String s1, String s2)
    {
        char misc1 = ' ';
        char misc2 = ' ';
        if (s1.length() == s2.length()) {
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    cnt++;
                    if (cnt > 2) {
                        return false;
                    }
                    if (misc1 != ' ' && misc1 == c2) {
                        if (c1 != misc2) {
                            return false;
                        }
                    }
                    else if (misc1 != ' ' && misc1 != c2) {
                        return false;
                    }
                    else {
                        misc2 = c2;
                        misc1 = c1;
                    }
                }
            }
            return cnt == 0 || cnt == 2;
        }
        return false;
    }
}
