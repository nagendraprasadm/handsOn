package org.nm.lc.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 *
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *
 * Example 1:
 *
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 * Example 2:
 *
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 * Example 3:
 *
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 */
public class BuddyStrings859
{
    public boolean buddyStrings(String s, String goal)
    {
        Map<Character, List<Integer>> map = new HashMap<>();
        int cnt = 0;
        int max = 1;
        if (s.length() == goal.length()) {
            for (int i = 0; i < s.length(); i++) {
                char curc = s.charAt(i);
                if (map.containsKey(curc)) {
                    List<Integer> indices = map.get(curc);
                    indices.add(i);
                    max = Math.max(max, indices.size());
                }
                else {
                    List<Integer> indices = new ArrayList<>();
                    indices.add(i);
                    map.put(curc, indices);
                }
            }

            for (int i = 0; i < goal.length(); i++) {
                char curc = goal.charAt(i);
                if (map.containsKey(curc)) {
                    List<Integer> indices = map.get(curc);
                    if (!indices.contains(i)) {
                        cnt++;
                        if (cnt > 2) {
                            return false;
                        }
                    }
                }
                else {
                    return false;
                }
            }
        }
        return cnt == 2 || (cnt == 0 && max >= 2);
    }
}
