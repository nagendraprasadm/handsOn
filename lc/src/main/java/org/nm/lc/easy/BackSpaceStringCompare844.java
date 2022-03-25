package org.nm.lc.easy;

import java.util.Stack;

public class BackSpaceStringCompare844
{
    public boolean backspaceCompare (String s, String t)
    {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curc = s.charAt(i);
            if (curc == '#' && !st1.isEmpty()) {
                st1.pop();
            }
            else {
                st1.push(curc);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char curc = t.charAt(i);
            if (curc == '#' && !st2.isEmpty()) {
                st2.pop();
            }
            else {
                st2.push(curc);
            }
        }

        if (st1.size() == st2.size()) {
            while (!st1.isEmpty()) {
                char c1 = st1.pop();
                char c2 = st2.pop();
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
