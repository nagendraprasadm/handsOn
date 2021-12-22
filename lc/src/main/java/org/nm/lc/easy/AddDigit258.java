package org.nm.lc.easy;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigit258
{
    public int addDigits (int num)
    {
        int sum = 0;
        while (true) {
            while (num > 0) {
                int r = num % 10;
                num = num / 10;
                sum += r;
            }
            if (sum / 10 > 0) {
                num = sum;
                sum = 0;
                continue;
            }
            else {
                break;
            }
        }
        return sum;
    }

    public int addDigitsOptimized (int num)
    {
        int sum = num;
        int q = sum / 10;
        while (q > 0) {
            num = sum;
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;

            }
            q = sum / 10;
        }
        return sum;
    }
}
