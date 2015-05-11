public class ReverseLinkedList {

    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode (int x) {
    		val = x;
    	}

    	@Override
        public String toString() {
 
        String data = "";
        ListNode current = this;
        do {
            data += current.value + ",";
            current = current.next;
           } while (current != null);
 
           return data;
        }
    }

	public static void main (String args[]) {
		// Preparing the linked list
		ListNode linkedList = new ListNode(5);
		linkedList.next = new ListNode(4);
		linkedList.next.next = new ListNode(3);
		linkedList.next.next.next = new ListNode(2);
		linkedList.next.next.next.next = new ListNode(1);

		System.out.println ("Original Linked List: " + linkedList.toString());

		// Recusively reverse linked list
		linkedList = recusivelyReverse(linkedList);
		System.out.println ("Recusively Reverse List: " + linkedList.toString());

		// Iteratively reverse linked list
		lnkedList = iterativelyReverse(linkedList);
		System.out.println ("Iteratively Reverse List: " + linkedList.toString());
	}

	/*
	* Recusively reverse a singly linked list 
	*/

	public static ListNode recusivelyReverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode remainingReverse = recusivelyReverse(head.next);

		// update the tail as head
		ListNode current = remainingReverse;
		while (current.next != null) {
			current = current.next;
		}
		current.next = head; // assign the head as a tail
                head.next = null; // set head.next as null, head is tail

                return remainingReverse;
	}

	/*
	* Iteratively reverse a singly linked list
	*/

	public static ListNode iterativelyReverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}
