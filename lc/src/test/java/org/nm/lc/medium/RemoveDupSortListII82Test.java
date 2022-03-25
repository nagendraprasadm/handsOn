package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.lc.ds.ListNode;

public class RemoveDupSortListII82Test extends TestCase
{
    private RemoveDupSortListII82 inst = new RemoveDupSortListII82();

    @Test
    public void testone(){
        ListNode n1 = new ListNode(1);
        ListNode head = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n1 = n2;
        n2 = new ListNode(5);
        n1.next = n2;
        n1 = n2;
        n2 = new ListNode(5);
        n1.next = n2;
        n1 = n2;
        n2 = new ListNode(5);
        n1.next = n2;
        ListNode res = inst.deleteDuplicates(head);
        assertNotNull(res);

    }
}