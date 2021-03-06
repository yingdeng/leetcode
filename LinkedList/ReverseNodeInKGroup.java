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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        int count = 0;
        while (cur != null){
            count++;
            ListNode next = cur.next;
            
            if (count == k){
                pre = reverse(pre, next);
                count=0;
            }
            cur = next;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end){
        if (pre == null || pre.next == null){
            return pre;
        }
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while (cur != end){
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
}