/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode oldPoint = head;
        RandomListNode newPoint = newHead;
        map.put(head, newHead);
        
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
                newPoint.random = null;
            }
            
            oldPoint = oldPoint.next;
            newPoint = newPoint.next;
        }
        
        return newHead;
    }
}