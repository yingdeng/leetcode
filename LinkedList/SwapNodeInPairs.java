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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if (cur.next == null) {
                break;
            }
            pre.next = cur.next;
            //cur.next = pre.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}