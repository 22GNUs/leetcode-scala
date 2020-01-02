/**
 * 第5题用dp重做
 * 
 * <pre>
 * dp[i][j] 表示从i to j 这段路径是否为回文
 * {@code dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]}
 *
 * 循环i从大到小, j从小到大, 举例:
 * 因为 dp[0][4] 依赖 dp[1][3], 所以i必须从大往小算, j必须从小到大算
 * </pre>
 */
class Q5DP {
  public String longestPalindrome(String s) {
    String ret = "";
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        // 排除首尾不相登的肯定不是回文
        if (s.charAt(i) != s.charAt(j)) {
          continue;
        }
        // 首尾相等, 并且中间只有一位或者中间也是回文
        if (j - i < 2 || dp[i + 1][j - 1]) {
          // 距离在2以内肯定是回文, 单字或双字
          dp[i][j] = true;
        }
        if (dp[i][j] && j - i + 1 > ret.length())
          ret = s.substring(i, j + 1);
      }
    }
    return ret;
  }
}
