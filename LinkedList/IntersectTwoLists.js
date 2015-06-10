/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if (headA === null || headB === null) {
        return null;
    }
    
    var pa = headA;
    var pb = headB;
    var lenA = 0;
    var lenB = 0;
    
    while (pa.next !== null) {
        pa = pa.next;
        lenA++;
    }
    
    while (pb.next !== null) {
        pb = pb.next;
        lenB++;
    }
    
    var diff = Math.abs(lenA - lenB);
    pa = headA;
    pb = headB;
    if (lenA < lenB) {
        while (diff != 0) {
            pb = pb.next;
            diff--;
        }
    }
    else {
        while (diff != 0) {
            pa = pa.next;
            diff--;
        }
    }
    
    while (pa != pb) {
        pa = pa.next;
        pb = pb.next;
    }
    
    return pa;
};