package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class WaterAndJug365Test extends TestCase
{

    private WaterAndJug365 inst = new WaterAndJug365();

    @Test
    public void testone() {
        assertTrue(inst.canMeasureWater(1,2,3));
    }

}