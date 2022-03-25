package org.nm.lc.easy;

import org.junit.Test;
import org.nm.lc.ds.TreeNode;
import org.nm.lc.ds.TreeUtil;

import static org.junit.Assert.*;

public class SecondMinNodeBT671Test
{

    SecondMinNodeBT671 inst = new SecondMinNodeBT671();

    @Test
    public void testOne(){
        TreeNode rootNode = TreeUtil.buildTreeFromArray(new Integer[]{1,1,1,1,1,1,1,null,null,null,null,null,null,1,2});
        int min = inst.findSecondMinimumValue(rootNode);
        assertEquals(2, min);
    }

}