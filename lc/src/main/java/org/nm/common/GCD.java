package org.nm.common;

public class GCD
{
    /**
     * BASEd on euclidean algorithm
     * @param a
     * @param b
     * @return
     */
    public int findGCD (int a, int b)
    {
        return b > 0 ? findGCD(b, a % b) : a;
    }
}
