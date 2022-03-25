package org.nm.lc.medium;

import org.nm.lc.ds.ListNode;

import java.util.Stack;

public class ReverseNodesKGroup25
{
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode(-1);
        ListNode f = head;
        dum.next = f;
        ListNode prev = dum;
        int cnt = 1;
        ListNode l = head;
        while(l != null && cnt < k){
            l = l.next;
            cnt++;
        }
        ListNode ns = null;
        if(l != null){
            ns = l.next;
        }
        while(l != null){
            //swap the nodes from f to l
            ListNode t = reverse(f, k, ns);
            //prev next to l
            prev.next = l;
            //f next to ns
            f.next = ns;
            //make f as prev
            prev = f;
            //in the mean time track new l
            f = ns;
            l = t;
            ns = l != null ? l.next : null;
        }
        head = dum.next;
        dum.next = null;
        return head;
    }

    private ListNode swapNodes(ListNode prev, ListNode f, ListNode l){
        ListNode t = f;
        ListNode ll = l;
        Stack<ListNode> s = new Stack<>();
        while(t != l){
            s.push(t);
            t = t.next;
            ll = ll != null ? ll.next : null;
        }
        s.push(t);
        ll = ll != null ? ll.next : null;
        while(!s.isEmpty()){
            ListNode pop = s.pop();
            prev.next = pop;
            prev = pop;
        }
        return ll;
    }

    private ListNode swap(ListNode f, ListNode l, int k){
        ListNode t = f;
        ListNode ll = l;
        ListNode p = t;
        t = t.next;
        int cnt = 2;
        while(cnt < k){
            ListNode temp = t.next;
            t.next = p;
            p = t;
            t = temp;
            ll = ll != null ? ll.next : null;
            k++;
        }
        t.next = p;
        ll = ll != null ? ll.next : null;
        return ll;
    }

    private ListNode reverse(ListNode f, int k, ListNode ns){
        int cnt = 1;
        ListNode cur = f.next;
        ListNode prev = f;
        while(cur != null && cnt < k){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            cnt++;
            ns = ns != null ? ns.next : null;
        }
        return ns;
    }
}
