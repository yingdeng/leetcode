public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0 || A == null) {
            return 0;
        }
        
        int[] sum = new int[A.length];
        // the sum of current number 
        sum[0] = A[0];
        // the whole sum of the consecutive number in the array
        int max = A[0];
        
        for (int i = 1; i <= A.length-1; i++) {
            sum[i] = Math.max(A[i], sum[i-1]+A[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}