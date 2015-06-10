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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, ArrayList<Integer> result){
        if (root == null){
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}