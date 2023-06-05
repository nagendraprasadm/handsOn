package org.nm.lc.easy;

/**
 * Try Divide and Conquer
 */
public class LongNiceSubStr1763
{



    public String longestNiceSubstring(String s) {
        return "";
    }

    private int getVal(char c){
        if(c - 'a' < 0){
            return -1 * (c - 'A');
        }else{
            return c - 'a';
        }
    }
}
