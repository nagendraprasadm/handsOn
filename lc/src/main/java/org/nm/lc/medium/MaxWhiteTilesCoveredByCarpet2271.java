package org.nm.lc.medium;

/**
 * TODO:
 */
public class MaxWhiteTilesCoveredByCarpet2271
{
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        //Sort the array
        //Start from fist element in array
        //prev carpet covered = 0th length
        // max = prev
        // loop through from 1 -> n-1
            /*
             Three use cases
             1. Prev has carpet covered
                start from cur
                len covered is within cur element
             2. Prev is shorter than carpet
                include cur till carpet length
                cur len covered is (carept len - (cur start and prev end) - prev length
                tiles covered = prev len + cur len covered
             3. prev is longer than carpet
                start from prev where carpet ends until carpet length
                prev len = prev end - (prev start + carpet len - 1)
                cur len covered is (carept len - (prev len) - (cur start and prev end)


                Mix of prev + cur
                Start from cur
             */
            // Check the cur number of tiles : end - start + 1
            // Prev Len + (start - prev end) + start till carpet length


        return 0;
    }
}
