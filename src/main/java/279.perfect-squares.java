class Q279DP {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = i;
      for (int j = 0; i - j * j >= 0; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }
}
