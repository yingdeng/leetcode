/*
Maximum Subarray - 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
<<<<<<< HEAD
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
=======

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

>>>>>>> c82b2decd465a6c9af48d90d8d57606a4456d950
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
which is more subtle.
*/

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
            sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }
}
