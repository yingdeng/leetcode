public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = search(board, word, 0, i, j, visited);
                    if (result) {
                       return true; 
                    }
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || 
            board[i][j] != word.charAt(index)) {
                   return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean rst = search(board, word, index+1, i+1, j, visited) ||
                      search(board, word, index+1, i-1, j, visited) ||
                      search(board, word, index+1, i, j+1, visited) ||
                      search(board, word, index+1, i, j-1, visited);
        visited[i][j] = false;
        return rst;
    }
}