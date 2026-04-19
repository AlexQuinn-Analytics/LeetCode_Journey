import java.util.*;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, i, j, visited, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, int baseX, int baseY, boolean[][] visited, StringBuilder sb) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y])
            return;

        visited[x][y] = true;
        sb.append(x - baseX).append(',').append(y - baseY).append(';');

        dfs(grid, x + 1, y, baseX, baseY, visited, sb);
        dfs(grid, x - 1, y, baseX, baseY, visited, sb);
        dfs(grid, x, y + 1, baseX, baseY, visited, sb);
        dfs(grid, x, y - 1, baseX, baseY, visited, sb);
    }
}