class WordDictionary {
    class TrieNode{
        TrieNode[]children=new TrieNode[26];
        boolean isWord;
    }
    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.isWord=true;
    }
    
    public boolean search(String word) {
        return dfs (word, 0, root);
    }
    private boolean dfs(String word,int index, TrieNode node){
        if (node == null) return false;

        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            int idx = c - 'a';
            return dfs(word, index + 1, node.children[idx]);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (dfs(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}