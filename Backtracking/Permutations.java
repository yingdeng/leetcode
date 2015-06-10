public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(num == null || num.length == 0){
            return result;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        permuteHelper(result, list, num);
        return result;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num){
            if(list.size() == num.length){
                result.add(new ArrayList<Integer>(list));
                return;
            }
            
            for(int i=0; i<num.length; i++){
                if(list.contains(num[i])){
                    continue;
                }
                list.add(num[i]);
                permuteHelper(result, list, num);
                list.remove(list.size()-1);
            }
        }
}