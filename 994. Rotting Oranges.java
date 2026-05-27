class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // 1. 把所有初始腐烂橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 没有新鲜橘子
        if (fresh == 0) return 0;

        int minutes = -1;

        // 2. 多源 BFS
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    fresh--;
                    q.offer(new int[]{nx, ny});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}