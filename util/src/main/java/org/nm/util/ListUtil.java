package org.nm.util;

import java.util.List;

public class ListUtil
{
    public static boolean checkExists (List<String> inp, String key)
    {
        for (String elem : inp) {
            if (key.equals(elem)) {
                return true;
            }
        }
        return false;
    }
}
