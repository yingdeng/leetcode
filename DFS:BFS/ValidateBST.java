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
   public boolean isValidBST(TreeNode root) {
       ArrayList<Integer> dummy = new ArrayList<>();
       return helper(root, dummy);
   }
   
   private boolean helper(TreeNode root, ArrayList<Integer> dummy) {
       if (root == null) {
           return true;
       }
       boolean left = helper(root.left, dummy);
       if (dummy.size() == 0) {
           dummy.add(root.val);
       }
       else {
           if (dummy.get(0) != null && root.val <= dummy.get(0)) {
              return false;
           }
           dummy.set(0, root.val);
       }
       boolean right = helper(root.right, dummy);
       return left && right;
   }
}