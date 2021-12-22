package org.nm.lc.easy;

import org.nm.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BTInOrderTraversal94
{

    public List<Integer> inorderTraversal (TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (prev != null && node.left == prev) {
                result.add(node.val);
                stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                }
                else if (!stack.isEmpty()) {
                    node = stack.pop();
                    result.add(node.val);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
                prev = node;
            }
            else {
                while (node.left != null) {
                    stack.push(node.left);
                    node = node.left;
                }
                result.add(node.val);
                stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                }
                else if (prev != null && node == prev.right && !stack.isEmpty()) {
                    node = stack.pop();
                    result.add(node.val);
                }
                prev = node;
            }

        }
        return result;
    }
}
