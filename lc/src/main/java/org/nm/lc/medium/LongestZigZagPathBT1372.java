package org.nm.lc.medium;

import org.nm.lc.ds.TreeNode;

public class LongestZigZagPathBT1372
{
    public int longestZigZag(TreeNode root) {
        int[] cnt = dfs(root);
        return cnt[2] > 0 ? cnt[2]  : 0;
    }

    private int[] dfs(TreeNode root){
        if(root != null){
            int[] lr = dfs(root.left);
            int[] rr = dfs(root.right);
            int[] res = new int[3];
            res[0] = root.left != null ? 1 + lr[1] : 0;
            res[1] = root.right != null ? 1 + rr[0] : 0;
            int max = Math.max(res[0], res[1]);
            max = Math.max(max, lr[2]);
            max = Math.max(max, rr[2]);
            res[2] = max;
            return res;
        }
        return new int[]{0,0,0};
    }
}
