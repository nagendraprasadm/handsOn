package org.nm.lc.medium;

import java.util.*;

/**
 * TODO
 *
 * Current approach is wrong as there are infinite possibilities
 *
 * Comparing the current only might not lead to correct result.
 *
 * Approach to take:
 *
 * Sort the characters based on connected components.
 */
public class SmallestStringsWIthSwaps1202
{
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        return dfs(s, pairs);
    }

    private String dfs(String s, List<List<Integer>> pairs){
        String prevS = s;
        for(List<Integer> pair : pairs){
            String curS = swap(s, pair.get(0), pair.get(1));
            if(curS.compareTo(prevS) < 0){
                prevS = dfs(curS, pairs);
            }
        }
        return prevS;
    }

    private String swap(String s, int i, int j){
        char ic = s.charAt(i);
        char jc = s.charAt(j);
        char[] arr = s.toCharArray();
        arr[j] = ic;
        arr[i] = jc;
        return new String(arr);
    }
}
