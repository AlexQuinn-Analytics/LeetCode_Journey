class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]failed=new boolean[s.length()];
        return dfs(s,wordDict,0,failed);
    }
    public boolean dfs(String s, List<String>wordDict, int index, boolean[]failed){
        if (index==s.length()){
            return true;
        }
        if (failed[index])return false;

        for (int i=index+1;i<=s.length();i++){
            String substring=s.substring(index,i);
            if (wordDict.contains(substring)){
                if (dfs(s,wordDict,i,failed)){
                    return true;
                }
            }
        }
        failed[index]=true;
        return false;
    }
}