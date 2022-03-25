package org.nm.lc.easy;

import org.nm.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal102
{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null){
            TreeNode trk = new TreeNode();
            Queue<TreeNode> qu = new LinkedList<>();
            qu.add(root);
            qu.add(trk);
            List<Integer> lvl = new ArrayList<>();
            while(!qu.isEmpty()){
                TreeNode cur = qu.remove();
                if(cur == trk){
                    res.add(lvl);
                    lvl = new ArrayList<>();
                    if (!qu.isEmpty()) qu.add(trk);
                }else{
                    lvl.add(cur.val);
                    if(cur.left != null){
                        qu.add(cur.left);
                    }
                    if(cur.right != null){
                        qu.add(cur.right);
                    }
                }
            }
        }
        return res;
    }
}
