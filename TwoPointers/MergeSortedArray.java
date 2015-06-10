public class Solution{
    public void merge(int[] A, int m, int[] B, int n){
        
        int i = m-1;
        int j = n-1;
        int counter = m+n-1;
        
        while(i>=0 && j>=0){
            if(A[i] > B[j]){
                A[counter] = A[i];
                i--;
            }
            else{
                A[counter] = B[j];
                j--;
            }
            counter--;
        }
        while(j>=0){
            A[counter] = B[j];
            j--;
            counter--;
        }
    }
}