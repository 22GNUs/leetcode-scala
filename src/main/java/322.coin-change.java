/*
 * Q322动态规划
 * <pre>
 * 思路: f[i] = min{f[i - coins[0]] + 1, ..., f[i - [coins[n - 1]]] + 1}
 * 举例: coins为2, 5, 7, amount为30, 则
 * f[30] = min{f[28] + 1, f[25] + 1, f[23] + 1}
 * </pre>
 */
class Q322 {
  public int coinChange(int[] coins, int amount) {
    int[] f = new int[amount + 1];
    // 初始化
    f[0] = 0;
    for (int i = 1; i < f.length; i++) {
      f[i] = Integer.MAX_VALUE;
      for (int j = 0; j < coins.length; j++) {
        // 目标值, 除了这次的硬币以外
        int target = i - coins[j];
        // 1. 数组不能越界
        // 2. 如果前一次的值也是MAX_VALUE, 那就不用算了
        if (target >= 0 && f[target] != Integer.MAX_VALUE) {
          // 每一次和上一次比较, 取更小的值, 题目要求是最少次数
          f[i] = Math.min(f[i], f[target] + 1);
        }
      }
    }
    if (f[amount] != Integer.MAX_VALUE) {
      return f[amount];
    }
    return -1;
  }
}
