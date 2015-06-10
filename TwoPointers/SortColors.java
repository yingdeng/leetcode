public class Solution {
    
    private void swap(int[]A, int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        
    public void sortColors(int[] A) {
        if(A.length == 0 || A == null){
            return;
        }
        int noRed = 0;
        int noBlue = A.length-1;
        int i = 0;
        while(i<=noBlue){
            if(A[i] == 0){
                swap(A, noRed, i);
                i++;
                noRed++;
            }
            else if(A[i] == 2){
                swap(A, noBlue, i);
                noBlue--;
            }
            else{
                i++;
            }
        }
    }
}