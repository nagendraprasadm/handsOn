package org.nm.lc.medium;

import org.nm.lc.ds.TreeNode;

public class LCABST236
{

    private TreeNode parent;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        rec(root, p, q);
        return parent;
    }

    public int rec(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            int rr = 0;
            int rl = 0;
            int resp = 0;
            if(root == p){
                rl = rec(root.left, p, q);
                rr = rec(root.right, p, q);
                resp = (rl == 2 || rr == 2) ? 3 : 1;
            }else if (root == q){
                rl = rec(root.left, p, q);
                rr = rec(root.right, p, q);
                resp = (rl == 1 || rr == 1) ? 3 : 2;
            }else{
                rl = rec(root.left, p, q);
                rr = rec(root.right, p, q);
                resp = rr + rl;
            }
            if(resp == 3){
                parent = root;
                return 0;
            }
            return resp;
        }
        return 0;
    }
}
