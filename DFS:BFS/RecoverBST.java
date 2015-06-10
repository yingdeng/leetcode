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
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        findNodes(root);
        reverseNodes(first, second);
    }
    
    public void findNodes(TreeNode root) {
        if (root == null){
            return;
        }
        findNodes(root.left);
        if (pre == null) {
            pre = root;
        }
        else {
            if (pre.val > root.val) {
                if (first == null){
                    first = pre;
                    second = root;
                }
                else {
                    second = root;
                }
            }
            pre = root;
        }
        findNodes(root.right);
    }
    
    public void reverseNodes(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}