/*

Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

*/



public class RemoveListElements {
	public class ListNode {
    	int val;
    	ListNode next;
    	ListNode (int x) {
    		val = x;
    	}
    }

    public ListNode removeElements (ListNode head, int val) {
    	if (head == null) {
    		return head;
    	}

    	ListNode cur = head;
    	ListNode prev = null;

    	while (cur != null) {
    		if (cur.val == val) {
    			if (cur == head) {
    				head = head.next;
    			}
    			else {
    				prev.next = cur.next;
    			}
    		}
    		else {
    			prev = cur;
    		}
    		cur = cur.next;
    	}
    	return head;
}