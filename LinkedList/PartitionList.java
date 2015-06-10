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
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        
        ListNode small = smallDummy;
        ListNode big = bigDummy;
        
        while(head != null){
            if(head.val < x){
                small.next = head;
                small = head;
            }
            else{
                big.next = head;
                big = head;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}