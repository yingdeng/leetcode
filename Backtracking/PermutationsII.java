/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, list, visited, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            //return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
