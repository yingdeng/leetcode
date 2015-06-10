public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (n == 0 || n < k){
            return res;
        }
        helper(res, list, n, k, 1);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, 
        ArrayList<Integer> list, int n, int k, int start) {
            if (list.size() == k){
                res.add(new ArrayList<Integer>(list));
                return;
            }
            for(int i=start; i<=n; i++){
                list.add(i);
                helper(res, list, n, k, i+1);
                list.remove(list.size()-1);
            }
        }
}