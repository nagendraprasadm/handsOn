package org.nm.lc.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MaxBagsFullCapcityRocks2279
{
    private static final Logger logger = LoggerFactory.getLogger(
        MaxBagsFullCapcityRocks2279.class);

    public int maximumBags (int[] capacity, int[] rocks, int additionalRocks)
    {
        int n = capacity.length;
        int[] toFill = new int[n];
        for (int i = 0; i < n; i++) {
            toFill[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(toFill);
        int res = 0;
        for (int curFill : toFill) {
            if (additionalRocks >= curFill) {
                additionalRocks -= curFill;
                res++;
            }
        }
        return res;
    }
}
