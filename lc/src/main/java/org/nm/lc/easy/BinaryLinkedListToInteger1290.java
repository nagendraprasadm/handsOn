package org.nm.lc.easy;

import org.nm.lc.ds.ListNode;

/**
 * <pre>
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 * </pre>
 */
public class BinaryLinkedListToInteger1290
{
    public int getDecimalValue(ListNode head) {

        int sum = 0;
        while(head != null){
            ListNode next = head.next;
            if(next != null){
                sum = (2 * sum) + (head.val * 2);
            }else{
                sum += head.val;
            }
            head = next;
        }
        return sum;
    }
}
