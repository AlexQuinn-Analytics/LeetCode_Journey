class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        m=board.length;
        n=board[0].length;
        for (String word:words){
            insert(word);
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dfs (board, i ,j ,root);
            }
        }
        return res;
    }
    class TrieNode{
        TrieNode[]children=new TrieNode[26];
        String word;
    }
    private TrieNode root=new TrieNode();
    private int m,n;
    private List<String>res=new ArrayList<>();
    private void insert(String word){
        TrieNode node=root;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.word=word;
    }
    private void dfs(char[][]board, int i, int j, TrieNode node){
        if (i>=m||i<0||j>=n||j<0) return;
        char c=board[i][j];
        if (board[i][j]=='#') return;
        TrieNode next=node.children[c-'a'];
        if (next==null) return;
        if (next.word!=null){
            res.add(next.word);
            next.word=null;
        }
        board[i][j]='#';
        int[]dx={-1,1,0,0};
        int[]dy={0,0,1,-1};
        for (int k=0;k<4;k++){
            dfs (board, i+dx[k],j+dy[k],next);
        }
        board[i][j]=c;
    }

}