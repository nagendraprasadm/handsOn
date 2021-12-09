package org.nm.lc.easy;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber9
{
    /**
     * Not a great approach
     * Drawbacks :
     * New Data Structure/collection used to store all the elements.
     * Comparing every element done from mid. Not required
     *
     * @param x
     * @return
     */
    public boolean isPalindromeOne (int x)
    {
        if (x < 0)
            return false;
        else if (x == 0)
            return true;
        else {
            List<Integer> nums = new ArrayList<>();
            int q = 0;
            int r = 0;
            while (x > 0) {
                q = x / 10;
                r = x % 10;
                nums.add(r);
                x = q;
            }
            int size = nums.size();
            if (size == 1) {
                return true;
            }
            else {
                int mid = size / 2;
                mid = mid - 1;
                int fwd = size % 2 == 0 ? mid + 1 : mid + 2;
                while (mid >= 0) {
                    if (nums.get(mid--) != nums.get(fwd++)) {
                        return false;
                    }
                }

            }
            return true;
        }
    }

    /**
     * Reverse until mid and compare the first half and reversed second half.
     *
     * @param x
     * @return
     */
    public boolean isPalindromeTwo (int x)
    {
        if (x < 0)
            return false;
        else if (x == 0)
            return true;
        else if(x % 10 == 0 && x != 0){
            return false;
        }
        else {

            int rev = 0;
            while (x > rev) {
                rev = (rev * 10) + (x % 10);
                x = x / 10;
            }
            return x == rev || (x == rev / 10);
        }
    }
}
