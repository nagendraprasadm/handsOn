package org.nm.lc.easy;

import org.nm.lc.ds.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class SortedArrToBST108
{
    public TreeNode sortedArrayToBST (int[] nums)
    {
        return subTree(nums, 0, nums.length - 1);
    }

    private TreeNode subTree (int[] nums, int lo, int hi)
    {
        if (lo == hi) {
            return new TreeNode(nums[lo], null, null);
        }
        else if (lo < hi) {
            int mid = (lo + hi) / 2;
            return new TreeNode(nums[mid], subTree(nums, lo, mid - 1),
                                subTree(nums, mid + 1, hi));
        }
        return null;
    }
}
