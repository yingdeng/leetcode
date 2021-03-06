public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
      
        int i;
        int max;
        int sum = 0;
        
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        
        // from left to right
        left[0] = A[0];
        max = A[0];
        for(i=0; i<A.length-1; i++){
            left[i] = Math.max(max, A[i]);
            max = Math.max(max, A[i]);
        }
        
        // from right to left
        right[A.length-1] = A[A.length-1];
        max = A[A.length-1];
        for(i=A.length-2; i>=0; i--){
            right[i] = Math.max(max, A[i]);
            max = Math.max(max, A[i]);
        }
        
        // trapping water
        for(i=1; i<A.length-1; i++){
            int bit = Math.min(left[i], right[i]) - A[i];
            if(bit > 0){
                sum += bit;
            }
        }
        return sum;
    }
}