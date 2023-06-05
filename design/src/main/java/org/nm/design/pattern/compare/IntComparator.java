package org.nm.design.pattern.compare;

import java.util.Comparator;

public class IntComparator implements Comparator<Integer>
{

    @Override
    public int compare (Integer o1, Integer o2)
    {
        if (o1 == null && o2 == null) {
            return 0;
        }
        else if (o1 == null) {
            return 1;
        }
        else if (o2 == null) {
            return -1;
        }
        else {
            return o1 < o2 ? -1 : 1;
        }
    }
}
