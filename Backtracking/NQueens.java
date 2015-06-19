/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        search(n, new List<Integer>(), result);
        return result;
    }
    
    private boolean isValid(List<Integer> cols, int col){
        int row = cols.size();
        for (int i = 0; i < row; i++){
            if (cols.get(i) == col){
                return false;
            }
            if (i - cols.get(i) == row - col){
                return false;
            }
            if (i + cols.get(i) == row + col){
                return false;
            }
        }
        return true;
    }
    
    private void search(int n, List<Integer> cols, List<String[]> result){
        if(cols.size() == n){
            result.add(drawChessBoard(cols));
            return;
        }
        for(int col = 0; col < n; col++){
            if (!isValid(cols, col)){
                continue;
            }
            cols.add(col);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }
    
    private String[] drawChessBoard(List<Integer> cols){
        String[] chessBoard = new String[cols.size()];
        for (int i = 0; i < cols.size(); i++){
            chessBoard[i] = "";
            for (int j = 0; j < cols.size(); j++){
                if(j == cols.get(i)){
                    chessBoard[i] += "Q";
                }
                else{
                    chessBoard[i] += ".";
                }
            }
        }
        return chessBoard;
    }
}
