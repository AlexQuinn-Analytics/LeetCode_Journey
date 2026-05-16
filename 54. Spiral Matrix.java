class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        boolean[][] visited = new boolean[m][n];
        // 起始坐标(0,0)，起始方向0(向右)，计数0
        dfs(res,0,0,0,visited,matrix,0);
        for(int num : res) ans.add(num);
        return ans;
    }
    public void dfs(int[]res, int x, int y, int nowDir, boolean[][]visited, int[][]matrix, int count){
        int m=matrix.length;
        int n=matrix[0].length;
        if (count==m*n) return;
        if (visited[x][y]==true||x>=m||x<0||y>=n||y<0)return;
        visited[x][y]=true;
        res[count]=matrix[x][y];
        int nx = x + dirs[nowDir][0];
        int ny = y + dirs[nowDir][1];
        // 当前方向能走，继续同方向递归
        if(nx >= 0 && nx < m && ny >=0 && ny < n && !visited[nx][ny]){
            dfs(res, nx, ny, nowDir, visited, matrix, count + 1);
        }else{
            // 走不通，换下一个方向
            int nextDir = (nowDir + 1) % 4;
            nx = x + dirs[nextDir][0];
            ny = y + dirs[nextDir][1];
            dfs(res, nx, ny, nextDir, visited, matrix, count + 1);
        }
    }
}