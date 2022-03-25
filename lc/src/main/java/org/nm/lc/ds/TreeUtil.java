package org.nm.lc.ds;

public class TreeUtil
{

    public static TreeNode buildTreeFromArray (Integer[] inp)
    {
        if (inp != null && inp.length > 0) {
            TreeNode[] treeArr = new TreeNode[inp.length];
            for (int i = 1; i <= inp.length; i++) {
                if (i == 1) {
                    treeArr[0] = new TreeNode(inp[0]);
                }
                else {
                    TreeNode parent = treeArr[(i/2) - 1];
                    boolean isLeft = i % 2 == 0;
                    TreeNode newNode = inp[i-1] == null ? null : new TreeNode(inp[i-1]);
                    treeArr[i-1] = newNode;
                    if (isLeft) {
                        parent.left = newNode;
                    }
                    else {
                        parent.right = newNode;
                    }
                }
            }
            return treeArr[0];
        }
        return null;
    }
}
