package org.nm.lc.medium;

import org.nm.lc.ds.ListNode;

public class LinkedListCycleII142
{
    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        boolean hasCycle = false;
        while(l1 != null && l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1 == l2){
                hasCycle = true;
                break;
            }
        }
        if(hasCycle){
            l1= head;
            ListNode prev = l1;
            while(l1 != l2){
                l1 = l1.next;
                l2 = l2.next;
                prev = l1;
            }
            return prev;
        }else{
            return null;
        }
    }
}
