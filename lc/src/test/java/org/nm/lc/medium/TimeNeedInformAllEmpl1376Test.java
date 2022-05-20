package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class TimeNeedInformAllEmpl1376Test extends TestCase
{

    private TimeNeedInformAllEmpl1376 inst = new TimeNeedInformAllEmpl1376();

    @Test
    public void testone ()
    {
        assertEquals(3, inst.numOfMinutes(15, 0,
                                          new int[] { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5,
                                                      5, 6, 6 },
                                          new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,
                                                      0, 0, 0 }));
    }

}