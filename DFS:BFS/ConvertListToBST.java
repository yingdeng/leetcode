/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        
        h = head;
        
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return helper(0, size-1);
    }
    
    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode left = helper(start, mid-1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;
        h = h.next;
        TreeNode right = helper(mid+1, end);
        root.right = right;
        return root;
    } 
}