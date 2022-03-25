package org.nm.lc.easy;

public class UglyNumber263
{
    public boolean isUgly (int n)
    {
        if (n < 0) {
            return false;
        }
        else if (n == 1) {
            return true;

        }
        else {
            while (n > 1) {
                if (n % 5 == 0) {
                    n = n/ 5;
                }
                else if (n % 3 == 0) {
                    n = n/ 3;
                }
                else if (n % 2 == 0) {
                    n = n/ 2;
                }
                else {
                    return false;
                }
            }
            return true;

        }
    }
}
