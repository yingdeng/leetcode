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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<>();
        helper(root, pre);
    }
    
    private void helper(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;//prevent recover the curr node, error: overflow
        if (pre.size() == 0) {
            pre.add(root);
        }
        else {
            if (pre.get(0) != null) {
                pre.get(0).left = null;
                pre.get(0).right = root;
            }
        }
        pre.set(0, root);
        helper(root.left, pre);
        helper(right, pre);
    }
    
}