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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return null;
        }
        
        ListNode walker = head;
        ListNode runner = head;
        int i=0;
        while(runner != null && i<n){
            runner = runner.next;
            i++;
        }
        if(runner == null){
            n %= i;
            runner = head;
            i = 0;
            while(runner!=null && i<n){
                runner = runner.next;
                i++;
            }
        }
        while(runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }
        runner.next = head;
        ListNode newhead = walker.next;
        walker.next = null;
        
        return newhead;
    }
}