class Solution {
    int count=0;
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){
                if (grid[x][y]=='1'){
                    count++;
                    dfs(grid,x,y);
                }
            }
        }
        return count;
        
    }
    public void dfs(char[][]grid,int x, int y){
        int m=grid.length;
        int n=grid[0].length;
        if (x<0||x>=m||y<0||y>=n||grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        for (int i=0;i<4;i++){
            dfs(grid,x+dx[i],y+dy[i]);
        }
        return;
    }
}