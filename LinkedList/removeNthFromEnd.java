/*

Remove Nth Node From End of List 

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

*/

public class removeNthFromEnd {

	public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        for(int i=0; i<n; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        
        while(head != null){
            pre = pre.next;
            head = head.next;
        }

        pre.next = pre.next.next;
        return dummy.next;

	}
}