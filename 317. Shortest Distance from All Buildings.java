   static int shortestDistance(int[][] grid) {
           int m=grid.length;
           int n=grid[0].length;
        int count=0;
        int[][]dist=new int[m][n];
        int[][]reach=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    count++;
                    bfs(grid,i,j,m,n,dist,reach);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){
                if (count==reach[x][y]){
                    min=Math.min(dist[x][y],min);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
    private static void bfs(int[][]grid,int x, int y, int m, int n, int[][]dist,int[][]reach){
        Queue<Integer>q=new LinkedList<>();
        q.offer(x*n+y);
        int[][] disCurr=new int[m][n];
        while(!q.isEmpty()){
            int size=q.size();
        for (int k=0;k<size;k++){
            int cur=q.poll();
            int cx=cur/n;
            int cy=cur%n;
            int[]dx={-1,1,0,0};
            int[]dy={0,0,-1,1};
            for (int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if (nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==0){
                    grid[nx][ny]=3;
                    disCurr[nx][ny]+=disCurr[cx][cy]+1;
                    dist[nx][ny]+=disCurr[nx][ny];
                    reach[nx][ny]++;
                    q.offer(nx*n+ny);
                }
            }
        }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==3){
                    grid[i][j]=0;
                }
            }
        }
    }