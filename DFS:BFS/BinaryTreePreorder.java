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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(TreeNode root, ArrayList<Integer> result) {
        if(root == null){
            return;
        }
        result.add(root.val);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
        
    }
}