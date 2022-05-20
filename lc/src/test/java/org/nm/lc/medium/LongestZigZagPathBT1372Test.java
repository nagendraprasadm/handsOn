package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.lc.ds.TreeNode;
import org.nm.lc.ds.TreeUtil;

public class LongestZigZagPathBT1372Test extends TestCase
{
    private LongestZigZagPathBT1372 inst = new LongestZigZagPathBT1372();

    @Test
    public void testone ()
    {
        TreeNode main = new TreeNode(1);
        main.left = null;
        main.right = new TreeNode(1);
        TreeNode root = main.right;
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root = root.right;
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        TreeNode left = root.left;
        left.setRight(new TreeNode(1).setRight(new TreeNode(1)));
        assertEquals(3, inst.longestZigZag(main));
    }

}