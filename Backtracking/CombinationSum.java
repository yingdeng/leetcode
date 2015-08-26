public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        helper(candidates, 0, target, list, result);
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, ArrayList<Integer> list,
        ArrayList<ArrayList<Integer>> result){
            
            if (target == 0) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            
            for (int i=index; i<candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i-1] || target < candidates[i]) {
                    continue;
                }
                
                list.add(candidates[i]);
                helper(candidates, i, target - candidates[i], list, result);
                list.remove(list.size()-1);
            }
        }
}
