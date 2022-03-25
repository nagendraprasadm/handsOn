package org.nm.lc.easy;

/**
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 */
public class ReverseStringII541
{
    public String reverseStr (String str, int k)
    {
        int l = str.length();
        int ix = 0;
        StringBuilder sb = new StringBuilder();

        while (ix < l) {
            int s = ix;
            int e = ix + k - 1 < l ? ix + k - 1 : l - 1;
            if(s <= e){
                char[] arr = new char[e - s + 1];
                while (s < e) {
                    arr[s-ix] = str.charAt(e);
                    arr[e-ix] = str.charAt(s);
                    e--;
                    s++;
                }
                if(s == e){
                    arr[s - ix] = str.charAt(s);
                }
                sb.append(new String(arr));
            }
            /*if(s == e){
                sb.append(str.charAt(s));
            }*/
            ix = ix + k;
            if(ix <= l){
                e = ix + k <= l ? ix + k : l;
                sb.append(str.substring(ix, e));
                ix = e;
            }
        }
        return sb.toString();
    }
}
