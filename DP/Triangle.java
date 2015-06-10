public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int trSize = triangle.size();
        int[] res = new int[triangle.size()];
        
        // Init the numbers from last row
        for (int i = 0; i < triangle.get(trSize - 1).size(); i++) {
            res[i] = triangle.get(trSize - 1).get(i);
        }
        
        for (int i = trSize - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j); 
            }
        }
        return res[0];
    }
}