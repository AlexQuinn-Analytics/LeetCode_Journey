static int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;

    int n = costs.length;
    // 一维 dp 数组：dp[i] 表示 前 i 间房的最小总花费
    int[][] dp = new int[n][3]; // 这里是 3 个颜色的总花费，本质还是一维思路

    // 初始化：第 0 间房的花费
    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];

    // 累积 + 更新 核心循环
    for (int i = 1; i < n; i++) {
        dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
    }

    // 最后一间的三个总花费取最小
    return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
}