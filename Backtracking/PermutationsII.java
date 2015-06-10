public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> list, boolean[] visited, int[] num){
        if(list.size() == num.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(visited[i] == true || (i != 0 && num[i] == num[i-1] && visited[i-1] == false)){
                continue;
            }
            visited[i] = true;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}