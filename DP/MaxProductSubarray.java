public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        
        int max = A[0];
        int min = A[0];
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            int max_copy = max;
            max = Math.max(Math.max(A[i]*max, A[i]), A[i]*min);
            min = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min);
            res = Math.max(res, max);
        }
        
        return res;
    }
}