public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        int left;
        int right;
        int mid;
        
        if(A.length == 0 || A == null){
            return result;
        }
        
        //left bound
        left = 0;
        right = A.length-1;
        while(left+1 < right){
            mid = left+(right-left)/2;
            if(A[mid] == target){
                right = mid;
            }
            else if(A[mid] < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(A[left] == target){
            result[0] = left;
        }
        else if(A[right] == target){
            result[0] = right;
        }
        else{
            result[0] = result[1] = -1;
            return result;
        }
        
        // Right bound
        left = 0;
        right = A.length-1;
        while(left+1 < right){
            mid = left+(right-left)/2;
            if(A[mid] == target){
                left = mid;
            }
            else if(A[mid] < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(A[right] == target){
            result[1] = right;
        }
        else if(A[left] == target){
            result[1] = left;
        }
        else{
            result[0] = result[1] = -1;
            return result;
        }
        return result;
        
    }
}