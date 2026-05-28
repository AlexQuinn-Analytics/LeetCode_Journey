class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        // 第一步：把所有 0 先放进队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1; // 标记未计算
                }
            }
        }
        
        // 第二步：一圈一圈向外扩散，只跑一次BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                // 只处理没算过的 1
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}