class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[]row=new HashSet[9];
        HashSet<Character>[]col=new HashSet[9];
        HashSet<Character>[]boxes=new HashSet[9];
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<9;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            boxes[i]=new HashSet<>();
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                char c=board[i][j];
                if (c=='.') continue;
                int boxIdx=(i/3)*3+j/3;
                if (row[i].contains(c)) return false;
                if (col[j].contains(c)) return false;
                if (boxes[boxIdx].contains(c)) return false;
                row[i].add(c);
                col[j].add(c);
                boxes[boxIdx].add(c);
            }
        }
        return true;
    }
}
