class Trie {
    private Trie[]children;
    private boolean isEnd;

    public Trie() {
        children=new Trie[26];
        isEnd=false;        
    }
    
    public void insert(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                node.children[idx]=new Trie();
            }
            node=node.children[idx];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie node=this;
        for (char c:word.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node=this;
        for (char c:prefix.toCharArray()){
            int idx=c-'a';
            if (node.children[idx]==null){
                return false;
            }
            node=node.children[idx];
        }
        return true;
        
    }
}