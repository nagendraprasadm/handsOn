package org.nm.lc.easy;

import org.junit.Assert;
import org.junit.Test;
import org.nm.lc.ds.TreeNode;

import java.util.List;

public class LevelOrderTraversal102Test
{
    LevelOrderTraversal102 inst = new LevelOrderTraversal102();

    @Test
    public void testone() {
        TreeNode node = new TreeNode(1);
        TreeNode nod1 = new TreeNode(2);
        node.left = nod1;
        TreeNode nod2 = new TreeNode(3);
        node.right = nod2;
        TreeNode nod3 = new TreeNode(4);
        TreeNode nod4 = new TreeNode(5);
        nod1.left = nod3;
        nod1.right = nod4;
        TreeNode nod5 = new TreeNode(6);
        TreeNode nod6 = new TreeNode(7);
        nod2.left = nod5;
        nod2.right = nod6;
        List<List<Integer>> res = inst.levelOrder(node);
        Assert.assertNotNull(res);
    }
}