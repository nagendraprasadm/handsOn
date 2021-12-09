package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class PalindromeNumber9Test extends TestCase
{
    PalindromeNumber9 palindromeNumber9 = new PalindromeNumber9();

    @Test
    public void testSimple ()
    {
        assertTrue(palindromeNumber9.isPalindromeTwo(121));
    }

    @Test
    public void testOne ()
    {
        assertFalse(palindromeNumber9.isPalindromeTwo(6423));
    }

    @Test
    public void testTwo ()
    {
        assertTrue(palindromeNumber9.isPalindromeTwo(6446));
    }

    @Test
    public void testThree ()
    {
        assertTrue(palindromeNumber9.isPalindromeTwo(4664));
    }

    @Test
    public void testFour ()
    {
        assertTrue(palindromeNumber9.isPalindromeTwo(46164));
    }
}