public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0){
            return 0;
        }
        if(A.length == 1){
            if(A[0] == elem){
                return 0;
            }
            else{
                return 1;
            }
        }
        
        //Two Pointer
        int i = 0;
        int j = 0;
        
        while(i < A.length && j < A.length){
            if(A[j] == elem){
                j++;
            }
            else{
                A[i] = A[j];
                i++;
                j++;
            }
        }
        return i;
    }
}