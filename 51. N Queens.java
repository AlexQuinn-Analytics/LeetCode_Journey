class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        char[][]board=new char[n][n];
        for (int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(board, res, n, 0);
        return res;
    }

    private void backtrack(char[][]board, List<List<String>>res, int n, int row){
        if (row==n){
            List<String>path=new ArrayList<>();
            for (int i=0;i<n;i++){
                path.add(new String(board[i]));
            }
            res.add(path);
            return;
        }
        for (int col=0;col<n;col++){
            if (!isLegal(row, col, board)){
                continue;
            }
            board[row][col]='Q';
            backtrack(board, res, n, row+1);
            board[row][col]='.';
        }
    }

    private boolean isLegal(int row, int col, char[][]board){
        int n=board.length;
        for (int i=0;i<row;i++){
            if (board[i][col]=='Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row-1, j = col+1;i >= 0 && j < n ; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}