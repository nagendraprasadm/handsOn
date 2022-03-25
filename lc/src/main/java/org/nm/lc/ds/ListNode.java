package org.nm.lc.ds;

public class ListNode
{
    public int val;

    public ListNode next;

    public ListNode ()
    {

    }

    public ListNode (int val)
    {
        this.val = val;
    }

    public ListNode (int val, ListNode next)
    {
        this.next = next;
        this.val = val;
    }
}
