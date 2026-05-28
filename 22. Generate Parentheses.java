class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        dfs(res,"",0,0,n);
        return res;
    }
    private void dfs(List<String>res,String path,int open, int close,int n){
        if (path.length()==n*2){
            res.add(path);
            return;
        }
        if (open<n){
            dfs(res,path+"(",open+1,close,n);
        }
        if (close<open){
            dfs(res,path+")",open,close+1,n);
        }
    }
}