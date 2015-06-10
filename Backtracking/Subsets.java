public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (S == null || S.length == 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(S);
        subsetsHelper(result, list, S, 0);
        return result;
    }
    
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] S, int pos){
            result.add(new ArrayList<Integer>(list));
            for(int i=pos; i<S.length; i++){
                list.add(S[i]);
                subsetsHelper(result, list, S, i+1);
                list.remove(list.size()-1);
            }
        }
}