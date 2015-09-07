/***

Palindrome Linked List 
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
 
    ListNode node = head;
    ListNode newHead = new ListNode(head.val);
 
    while(node.next != null) {
        ListNode temp = new ListNode(node.next.val);
        temp.next = newHead;
        newHead = temp;
        node = node.next;
    }
 
    ListNode p1 = head;
    ListNode p2 = newHead;
 
    while(p1!=null){
        if(p1.val != p2.val)
            return false;
 
        p1 = p1.next;
        p2 = p2.next;
    }
 
    return true;
    }
}