package org.nm.lc.easy;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * Constraints:
 * 0 <= x <= 231 - 1
 */
public class SquareRootX69
{
    // Number Overflow
    // Time Limit Exceeded
    public int mySqrt (int x)
    {
        if (x == 0 || x == 1) {
            return x;
        }
        else {
            int sqrt = x / 2;
            int prev = Integer.MAX_VALUE / sqrt < sqrt ? Integer.MAX_VALUE : sqrt * sqrt;
            if (prev <= x && Integer.MAX_VALUE / sqrt >= sqrt) {
                return sqrt;
            }
            sqrt--;
            while (sqrt > 0) {
                int cur =
                    Integer.MAX_VALUE / sqrt < sqrt ? Integer.MAX_VALUE : sqrt * sqrt;
                if (cur <= x && prev >= x && Integer.MAX_VALUE / sqrt >= sqrt) {
                    return sqrt;
                }
                prev = cur;
                sqrt--;
            }
            return sqrt;
        }
    }

    public int mySqrtBinarySearch (int x)
    {
        return binarySearch(x, 1, x);
    }

    private int binarySearch (int x, int lo, int hi)
    {
        if (x == 0 || x == 1) {
            return x;
        }
        else {
            if ((lo + 1) < hi) {
                int mid = (hi - lo) / 2 + lo;
                int cur = x/mid;
                if(cur == mid){
                    return mid;
                }
                else if (cur < mid) {
                    return binarySearch(x, lo, mid);
                }
                else {
                    return binarySearch(x, mid, hi);
                }
            }
            else {
                if(x/ hi >= hi){
                    return hi;
                }
                return lo;
            }
        }
    }
}
