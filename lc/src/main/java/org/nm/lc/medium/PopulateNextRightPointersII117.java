package org.nm.lc.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointersII117
{
    public Node connect (Node root)
    {
        Queue<Node> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        int sz = q.size();
        while (!q.isEmpty()) {
            Node prev = q.poll();
            if (prev.left != null)
                q.add(prev.left);
            if (prev.right != null)
                q.add(prev.right);

            int cnt = 1;
            while (cnt < sz) {
                Node cur = q.poll();
                cnt++;
                prev.next = cur;
                prev = cur;
                if (prev.left != null)
                    q.add(prev.left);
                if (prev.right != null)
                    q.add(prev.right);
            }
            sz = q.size();
        }
        return root;
    }

    public static class Node
    {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node ()
        {
        }

        public Node (int _val)
        {
            val = _val;
        }

        public Node (int _val, Node _left, Node _right, Node _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString ()
        {
            return "Node{" + "val=" + val + ", left=" + (left != null ?
                Integer.toString(left.val) :
                "NULL") + ", right=" + (right != null ?
                Integer.toString(right.val) :
                "NULL") + ", next=" + (next != null ? Integer.toString(next.val) : "NULL")
                + '}';
        }
    }
}
