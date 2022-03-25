package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.lc.ds.TreeNode;
import org.nm.lc.ds.TreeUtil;

public class LCABST236Test extends TestCase
{

    @Test
    public void testone(){
        LCABST236 inst = new LCABST236();
        TreeNode root = TreeUtil.buildTreeFromArray(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode res = inst.lowestCommonAncestor(root, p, q);
        assertEquals(res, root);
    }
}