/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode newhead = dummy;
            
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                newhead.next = head1;
                head1 = head1.next;
            }else{
                newhead.next = head2;
                head2 = head2.next;
            }
            newhead = newhead.next;
        }
        if(head1 == null){
            newhead.next = head2;
        }else{
            newhead.next = head1;
        }
        return dummy.next;
    }
        
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }
}