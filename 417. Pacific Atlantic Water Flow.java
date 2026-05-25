class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>res=new ArrayList<>();
        int count=0;
        int m=heights.length;
        int n=heights[0].length;
        boolean[][]pacific=new boolean[m][n];
        boolean[][]atlantic=new boolean[m][n];
        for (int i=0;i<m;i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,n-1);
        }
        for (int j=0;j<n;j++){
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,m-1,j);
        }
        for (int k=0;k<m;k++){
            for (int l=0;l<n;l++){
                if (pacific[k][l]&&atlantic[k][l]){
                    res.add(new ArrayList<>());
                    res.get(count).add(k);
                    res.get(count).add(l);
                    count++;
                }
            }
        }
        return res;
        
    }
    public void dfs(int[][]heights,boolean[][]visited,int x,int y){
        int m=heights.length;
        int n=heights[0].length;
        visited[x][y]=true;
        int[]dx={-1,1,0,0};
        int[]dy={0,0,1,-1};
        for (int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx>=0&&nx<m&&ny>=0&&ny<n&&!visited[nx][ny]&&heights[nx][ny]>=heights[x][y]){
                dfs(heights,visited,nx,ny);
            }
        }
    }
}