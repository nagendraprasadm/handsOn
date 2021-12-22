package org.nm.lc.easy;

import junit.framework.TestCase;
import org.nm.lc.ds.TreeNode;

import java.util.List;

public class BTInOrderTraversal94Test extends TestCase
{

    BTInOrderTraversal94 inst = new BTInOrderTraversal94();

    public void testOneNode ()
    {
        TreeNode root = new TreeNode(1);
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals((Integer)1, result.get(0));
    }

    public void testOneLeftNode ()
    {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals((Integer)2, result.get(0));
        assertEquals((Integer)1, result.get(1));
    }

    public void testOneRightNode ()
    {
        TreeNode root = new TreeNode(1,  null, new TreeNode(3));
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals((Integer)1, result.get(0));
        assertEquals((Integer)3, result.get(1));
    }

    public void testOneLeftRightNode ()
    {
        TreeNode root = new TreeNode(1,  new TreeNode(2), new TreeNode(3));
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals((Integer)2, result.get(0));
        assertEquals((Integer)1, result.get(1));
        assertEquals((Integer)3, result.get(2));
    }

    public void testMemoryLimitExceeded ()
    {
        TreeNode left = new TreeNode(1, null, new TreeNode(2));
        TreeNode root = new TreeNode(3,  left, null);
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
    }

    public void testMemoryLimitExceeded2 ()
    {
        TreeNode right = new TreeNode(4, new TreeNode(1), null);
        TreeNode left = new TreeNode(2, null, right);
        TreeNode root = new TreeNode(3,  left, null);
        List<Integer> result = inst.inorderTraversal(root);
        assertNotNull(result);
    }

}