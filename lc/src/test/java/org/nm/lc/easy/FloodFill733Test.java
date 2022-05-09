package org.nm.lc.easy;

import junit.framework.TestCase;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloodFill733Test extends TestCase
{
    private static final Logger logger = LoggerFactory.getLogger(FloodFill733Test.class);

    private FloodFill733 inst = new FloodFill733();

    @Test
    public void testone(){
        int[][] res = inst.floodFill(new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2);
        assertNotNull(res);
        logger.info(ArrayUtils.toString(res));
    }

    @Test
    public void testtwo(){
        int[][] res = inst.floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 1);
        assertNotNull(res);
        logger.info(ArrayUtils.toString(res));
    }
}