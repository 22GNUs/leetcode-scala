import java.util.List;

class Q120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[n][triangle.get(n - 1).size()];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      List<Integer> in = triangle.get(i);
      for (int j = 0; j < in.size(); j++) {
        int that = in.get(j);
        if (i == 0 && j == 0) {
          dp[i][j] = that;
        } else if (j == 0) {
          dp[i][j] = that + dp[i - 1][j];
        } else if (j == in.size() - 1) {
          dp[i][j] = that + dp[i - 1][j - 1];
        } else {
          dp[i][j] = that + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
        }
        if (i == n - 1 && j < in.size()) {
          min = Math.min(min, dp[i][j]);
        }
      }
    }
    return min;
  }
}
