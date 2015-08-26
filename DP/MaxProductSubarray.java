<<<<<<< HEAD

/*
Maximum Product Subarray - 
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
=======
/*
Maximum Product Subarray - 
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

>>>>>>> c82b2decd465a6c9af48d90d8d57606a4456d950
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

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
            max = Math.max(Math.max(A[i] * max, A[i]), A[i] * min);
            min = Math.min(Math.min(A[i] * max_copy, A[i]), A[i] * min);
            res = Math.max(res, max);
        }
        
        return res;
    }
}
