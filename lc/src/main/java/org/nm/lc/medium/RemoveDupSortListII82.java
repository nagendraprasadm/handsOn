package org.nm.lc.medium;

import org.nm.lc.ds.ListNode;

public class RemoveDupSortListII82
{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode newH = null;
        int cnt = 1;
        ListNode cur = prev.next;
        ListNode prevN = null;
        while(cur != null){
            if(cur.val == prev.val){
                cnt++;
            }else{
                if(cnt == 1){
                    if(prevN == null){
                        prevN = prev;
                        newH = prevN;
                    }else{
                        prevN.next = prev;
                        prevN = prev;
                    }

                }
                cnt = 1;
            }
            prev = cur;
            cur = cur.next;
        }
        if(cnt == 1){
            if(prevN == null){
                newH = prev;
            }else{
                prevN.next = prev;
            }
            prevN = prev;
        }
        prevN.next = null;
        return newH;
    }
}
