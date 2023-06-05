package org.nm.lc.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205
{

    public boolean isIsomorphic (String s, String t)
    {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Map<Character, Character> charmap = new HashMap<>();
        Map<Character, Character> revmap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!charmap.containsKey(arr1[i])) {
                if (!revmap.containsKey(arr2[i])) {
                    charmap.put(arr1[i], arr2[i]);
                    revmap.put(arr2[i],arr1[i]);
                }
                else if (revmap.get(arr2[i]) != (arr1[i])) {
                    return false;
                }
            }
            else {
                if (charmap.get(arr1[i]) != (arr2[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
