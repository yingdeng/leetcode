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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        while(cur != null){
            while(cur.next != null && cur.next.val == pre.next.val){
                cur = cur.next;
            }
            //pre.next = cur.next;
            if(pre.next == cur){
                pre = pre.next;
            }
            else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    
}