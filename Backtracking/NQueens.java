public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n<=0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col){
        int row = cols.size();
        for (int i=0; i<row; i++){
            if (cols.get(i) == col){
                return false;
            }
            if (i-cols.get(i) == row-col){
                return false;
            }
            if (i+cols.get(i) == row+col){
                return false;
            }
        }
        return true;
    }
    
    private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> result){
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
            cols.remove(cols.size()-1);
        }
    }
    
    private String[] drawChessBoard(ArrayList<Integer> cols){
        String[] chessBoard = new String[cols.size()];
        for (int i=0; i<cols.size(); i++){
            chessBoard[i] = "";
            for (int j=0; j<cols.size(); j++){
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