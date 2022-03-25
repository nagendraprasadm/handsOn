package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInStringIII557Test
{

    ReverseWordsInStringIII557 inst = new ReverseWordsInStringIII557();

    @Test
    public void testone() {
        String s = "Let's take LeetCode contest";
        System.out.println(inst.reverseWords(s));
    }
}