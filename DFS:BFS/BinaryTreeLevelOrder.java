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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode head = queue.poll();
                list.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}