package org.nm.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListUtil
{
    /**
     *
     * @param input - "[[],[],[]]"
     * @return
     */
    public static List<List<Integer>> fromString2D(String input){

        char[] arr = input.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = null;
        for(int i = 1; i < input.length() - 1; i++){
            if(arr[i] == '['){
                cur = new ArrayList<>();
            }else if(arr[i] == ']'){
                res.add(cur);
            }else if(Character.isDigit(arr[i])){
                cur.add(Character.getNumericValue(arr[i]));
            }
        }
        return res;
    }
}
