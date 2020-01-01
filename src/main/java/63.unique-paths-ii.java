/**
 * 思路:
 * 
 * <pre>
 * 还是跟Q62类似, f[i][j] = f[i - 1][j] + f[i][j - 1]
 * 只是两条路径中如果其中一条是障碍物则无视
 * </pre>
 */
class Q63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 如果该点为障碍点则为0
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
          // 初始情况, 这样写是防止后面两个条件越界
        } else if (i == 0 && j == 0) {
          dp[i][j] = 1;
          // 不能再简单的赋1处理, 要考虑直线前面的格子如果出现障碍, 则后面的格子都为0
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1];
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
