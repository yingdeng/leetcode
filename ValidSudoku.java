public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        
        // Check for row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } 
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]); 
            }
            set.clear();
        }
        
        // Check for column
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                } 
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        // Check for Sub-grid
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = k%3*3; j < k%3*3+3; j++) { 
                    if (board[i][j] == '.') {
                    continue;
                } 
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        return true;
    }
}