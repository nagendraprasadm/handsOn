package org.nm.lc.medium;

import junit.framework.TestCase;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.nm.lc.ds.LinkedListUtil;
import org.nm.lc.ds.ListNode;

public class ReverseNodesKGroup25Test extends TestCase
{
    private ReverseNodesKGroup25 inst = new ReverseNodesKGroup25();

    @Test
    public void testone(){
        ListNode head = LinkedListUtil.createListFromArr(new int[]{ 1, 2, 3, 4, 5, 6});
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(head)));
        ListNode res = inst.reverseKGroup(head, 3);
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(res)));
        assertNotNull(res);
        System.out.println("-----");
        head = LinkedListUtil.createListFromArr(new int[]{ 1, 2, 3, 4, 5, 6});
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(head)));
        res = inst.reverseKGroup(head, 1);
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(res)));
        assertNotNull(res);
        System.out.println("-----");
        head = LinkedListUtil.createListFromArr(new int[]{ 1, 2, 3, 4, 5, 6});
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(head)));
        res = inst.reverseKGroup(head, 2);
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(res)));
        assertNotNull(res);
        System.out.println("-----");
        head = LinkedListUtil.createListFromArr(new int[]{ 1, 2, 3, 4, 5, 6});
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(head)));
        res = inst.reverseKGroup(head, 6);
        System.out.println(ArrayUtils.toString(LinkedListUtil.createArrFromList(res)));
        assertNotNull(res);
        System.out.println("-----");
    }

    @Test
    public void testtwo() {
        inst.reverseKGroup(LinkedListUtil.createListFromArr(new int[]{1}), 1);
    }
}