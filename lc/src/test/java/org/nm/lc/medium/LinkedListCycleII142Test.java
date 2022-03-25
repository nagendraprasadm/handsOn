package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.lc.ds.ListNode;

public class LinkedListCycleII142Test extends TestCase
{

    LinkedListCycleII142 inst = new LinkedListCycleII142();

    @Test
    public void testone ()
    {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        node0.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        node7.next = node3;
        ListNode resN = inst.detectCycle(node0);
        assertEquals(3, resN.val)   ;
    }

}