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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        int level = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        
        while (!stack.isEmpty()){
            Stack<TreeNode> newStack= new Stack<>();
            list = new ArrayList<Integer>();
            
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if (level%2 == 0){
                    if (node.left != null){
                        newStack.push(node.left);
                        list.add(node.left.val);
                    }
                    if (node.right != null){
                        newStack.push(node.right);
                        list.add(node.right.val);
                    }
                }
                else {
                    if (node.right != null) {
                        newStack.push(node.right);
                        list.add(node.right.val);
                    }
                    if (node.left != null) {
                        newStack.push(node.left);
                        list.add(node.left.val);
                    }
                }
            }
            level++;
            if (list.size() > 0){
                result.add(list);
            }
            stack = newStack;
        }
        return result;
    }
    
}