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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        helper(root, sum, list, result);
        return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                list.add(root.val);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        helper(root.left, sum, list, result);
        helper(root.right, sum, list, result);
        list.remove(list.size() - 1);
    }
}