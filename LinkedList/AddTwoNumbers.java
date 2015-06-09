/*

Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		int carry = 0;
 
                ListNode dummy = new ListNode(0);
                //ListNode p1 = l1, p2 = l2, 
                ListNode helper = dummy;
 
                while(l1 != null || l2 != null){
                    if(l1 != null){
                       carry += l1.val;
                       l1 = l1.next;
                    }
                    if(l2 != null){
                       carry += l2.val;
                       l2 = l2.next;
                    }
 
                helper.next = new ListNode(carry%10);
                helper = helper.next;
                carry /= 10;
                }
 
                if(carry==1) 
                helper.next = new ListNode(1);
 
               return dummy.next;
        }
}
