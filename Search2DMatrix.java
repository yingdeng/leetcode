public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows*cols-1;
        int mid;
        
        while(start<=end){
            mid = start+(end-start)/2;
            int digit = matrix[mid/cols][mid%cols];
            if(target == digit){
                return true;
            }
            else if(target > digit){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return false;
    }
}