package org.nm.lc.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger13
{
    private Map<Character, Integer> romToNum = new HashMap<>();
    private Map<Character, Character> allowedPrev = new HashMap<>();
    private Map<Character, Integer> prevNum = new HashMap<>();

    public RomanToInteger13(){
        romToNum.put('I', 1);
        romToNum.put('V', 5);
        romToNum.put('X', 10);
        romToNum.put('L', 50);
        romToNum.put('C', 100);
        romToNum.put('D', 500);
        romToNum.put('M', 1000);
        allowedPrev.put('V', 'I');
        allowedPrev.put('X', 'I');
        allowedPrev.put('L', 'X');
        allowedPrev.put('C', 'X');
        allowedPrev.put('D', 'C');
        allowedPrev.put('M', 'C');
        prevNum.put('V', 4);
        prevNum.put('X', 9);
        prevNum.put('L', 40);
        prevNum.put('C', 90);
        prevNum.put('D', 400);
        prevNum.put('M', 900);
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] input = s.toCharArray();
        Character prev = input[0];
        result += romToNum.get(prev);
        for(int i = 1; i < input.length; i++){
            char cur = input[i];
            if (prev == allowedPrev.get(cur)){
                result -= romToNum.get(prev);
                result += prevNum.get(cur);
            }else{
                result += romToNum.get(cur);
            }
            prev = cur;
        }
        return result;
    }

    public int romanToIntVer3 (String s)
    {
        int result = 0;
        char[] input = s.toCharArray();

        int i = 0;
        while (i < input.length - 1) {
            if(romToNum.get(input[i]) > romToNum.get(input[i+1])){
                result += romToNum.get(input[i]);
            }else{
                result -= romToNum.get(input[i]);
            }
            i++;
        }
        return result + romToNum.get(input[i]);
    }

    public int romanToIntVer2 (String s)
    {
        int result = 0;
        char[] input = s.toCharArray();

        int i = 0;
        while (i < input.length) {
            char cur = input[i];
            if ((i < input.length - 1)
                &&  (allowedPrev.containsKey(input[i + 1]) && cur == allowedPrev.get(input[i + 1]))) {
                result += prevNum.get(input[i + 1]);
                i += 2;
            }
            else {
                result += romToNum.get(cur);
                i++;
            }
        }
        return result;
    }
}
