/*

Copy List With Ramdon Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Thoughts:
1. copy every node, i.e., duplicate every node, and insert it to the list
2. copy random pointers for all newly created nodes
3. break the list to two

4. Using HashMap which make it easier.

*/

public class CopyListWithRamdonPointer {

	class RandomListNode {
		int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRamdonList(RandomListNode head) {
    	if (head == null) {
    		return null;
    	}

    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);

        RandomListNode oldPoint = head;
        RandomListNode newPoint = newHead;

        oldPoint = oldPoint.next;
        while (oldPoint != null) {
        	RandomListNode tempNode = new RandomListNode(oldPoint.label);
        	map.put(oldPoint, tempNode);
        	newPoint.next = tempNode;
        	newPoint = tempNode;
            oldPoint = oldPoint.next;
        }

        oldPoint = head;
        newPoint = newHead;

        while (oldPoint != null) {
        	if (oldPoint.random != null) {
        		newPoint.random = map.get(oldPoint.random);
        	}
        	else {
        		newPoint.randorm = null;
        	}

        	oldPoint = oldPoint.next;
        	newPoint = newPoint.next;
        }
        return newHead;
    }

}


