public class Solution {
    public void setZeroes(int[][] matrix) {
    
       boolean rowFlag = false;
       boolean colFlag = false;
       
       // 1.Set first row and column are zero or not
       for(int i = 0; i < matrix.length; i++) {
           if (matrix[i][0] == 0) {
                   rowFlag = true;
                   break;
           }
       }
       for(int j = 0; j < matrix[0].length; j++) {
               if (matrix[0][j] == 0) {
                   colFlag = true;
                   break;
               }
        }
       
       // 2.Mark zeros on first row and column
       for (int i = 1; i < matrix.length; i++) {
           for(int j = 1; j < matrix[0].length; j++) {
               if (matrix[i][j] == 0) {
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
               }
           }
       }
       
       
       // 3.Use mark to set elements
       for (int i = 1; i < matrix.length; i++) {
           for(int j = 1; j < matrix[0].length; j++) {
               if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                   matrix[i][j] = 0;
               }
           }
       }
       
       // 4.Set first coolumn and row by using mark as first step
       if (rowFlag) {
           for(int i = 0; i < matrix.length; i++) {
               matrix[i][0] = 0;
           }
       }
       if (colFlag) {
           for(int j = 0; j < matrix[0].length; j++) {
               matrix[0][j] = 0;
           }
       }
       
    }
}