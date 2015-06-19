/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        if(num == null || num.length == 0) {
              return res;  
        } 
        Arrays.sort(num); 
        helper(num, 0, target, tempList, res);  
        return res;  
    }
    
    private void helper(int[] num, int start, int target, List<Integer> tempList,  
        List<List<Integer>> res) {
            if(target == 0){
                res.add(new ArrayList<Integer>(tempList));
                return;
            }
            if(target < 0){
                return;
            }
            for(int i = start; i < num.length; i++){
                if(i > start && num[i] == num[i - 1]){
                    continue;
                }
                tempList.add(num[i]);
                int newTarget = target - num[i];
                helper(num, i+1, newTarget, tempList, res);
                item.remove(item.size() - 1);
            }
        }
}
