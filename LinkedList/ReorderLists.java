/*

Reorder Lists

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/

public class ReorderLists {

	class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
    }

    public ListNode reorderLists (ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}

    	ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);

    }

    private ListNode findMiddle (ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head.next;

    	while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
    	}
        return slow;
    }

    private ListNode reverseNodes (ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}

    	ListNode pre = head;
    	ListNode cur = head.next;

    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}

    	return pre;
    }

    private void merge (ListNode head, ListNode mid) {
    	ListNode p1 = head;
    	ListNode p2 = mid;

    	while (head != null && mid != null) {
    		ListNode temp1 = p1.next;
    		ListNode temp2 = p2.next;

    		p1.next = p2;
    		p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
    	}
    }

}