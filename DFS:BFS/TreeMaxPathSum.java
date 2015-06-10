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
    int max = Integer.MIN_VALUE; // The node.val could be negative, so the max result could be nagetive also.
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftVal = maxSum(root.left);
        int rightVal = maxSum(root.right);
        
        int curMax = root.val;
        if (leftVal > 0) {
            curMax += leftVal;
        }
        if (rightVal > 0) {
            curMax += rightVal;
        }
        if (curMax > max) {
            max = curMax;
        }
        return Math.max(root.val, Math.max(leftVal+root.val, rightVal+root.val));
    }
}