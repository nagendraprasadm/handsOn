package org.nm.lc.ds;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeUtilTest
{

    @Test
    public void testOne(){
        TreeNode rootNode = TreeUtil.buildTreeFromArray(new Integer[]{1,2,3,4,5,6,7,null,null,10,11});
        assertNotNull(rootNode);
    }
}