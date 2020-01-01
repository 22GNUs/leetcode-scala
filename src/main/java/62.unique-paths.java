/**
 * 动态规划
 */
class Q62 {
  public int uniquePaths(int m, int n) {
    // 因为数组从0开始, 所以边界设置为m, n
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    // 数组的最后一个值是m - 1, n - 1
    return dp[m - 1][n - 1];
  }
}
