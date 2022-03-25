package org.nm.lc.ds;

public class LinkedListUtil
{
    public static ListNode createListFromArr (int[] arr)
    {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode cur = new ListNode(arr[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }

    public static int[] createArrFromList(ListNode head){
        int sz = 0;
        ListNode t = head;
        while(t != null){
            t = t.next;
            sz++;
        }
        int[] res = new int[sz];
        int i = 0;
        while(head != null){
            res[i++] = head.val;
            head = head.next;
        }
        return res;
    }
}
