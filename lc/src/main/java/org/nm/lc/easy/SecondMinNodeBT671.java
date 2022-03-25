package org.nm.lc.easy;

import org.nm.lc.ds.TreeNode;

import java.util.*;

public class SecondMinNodeBT671
{
    public int findSecondMinimumValue (TreeNode root)
    {
        Queue<TreeNode> st = new LinkedList<>();
        TreeNode markNode = new TreeNode(-1);
        st.add(root);
        st.add(markNode);
        int minVal = root.val;
        List<Integer> lst = new ArrayList<>();
        boolean found = false;
        while (!st.isEmpty()) {
            TreeNode pop = st.remove();
            if (pop.val == -1) {
                if (found) {
                    break;
                }
                else {
                    if(!st.isEmpty()){
                        st.add(markNode);
                    }
                }
            }
            else {
                int curVal = pop.val;
                if (curVal != minVal) {
                    lst.add(curVal);
                    found = true;
                }
                if (pop.right != null) {
                    st.add(pop.left);
                    st.add(pop.right);
                }
            }

        }
        if (found) {
            Collections.sort(lst);
            return lst.get(0);
        }
        else {
            return -1;
        }

    }
}
