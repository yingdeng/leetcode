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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}