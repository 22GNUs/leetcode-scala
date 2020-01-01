/**
 * Q55 jump game dynamic-programing
 * 思路:
 * <pre>
 * 每一步i只需要确认之前的步数中是否有满足
 * <@code f[i] = f[j] && f[j] + nums[j] >= i>
 * 即 每一步都至少有一条路径是通的, 并且这条路径可以通往i
 * </pre>
 */
class Q55 {
    public boolean canJump(int[] nums) {
      int n = nums.length;
      boolean[] dp = new boolean[n];       
      dp[0] = true;
      for (int i = 1; i < n; i++) {
        // 循环找之前跳过的步数是否有可以跳到i的, 只要有一条则可以到达i
        for (int j = 0; j < i; j++) {
          // 关键公式
          if (dp[j] && j + nums[j] >= i) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[n - 1];
    }
}
