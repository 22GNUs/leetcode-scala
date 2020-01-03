/**
 * 最大子序和动态规划 思路:
 * 
 * <pre>
 * 如果上一个数是负数, 说明中间断开了
 * 只需要比较当前的局部最大值跟当前值, 因为当前值不可能加到局部值上去了
 * 如果上一个数是正数, 则加上当前值有可能比最大值大(取决于当前值的正负)
 * </pre>
 */
class Q53DP {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    int max = nums[0];
    for (int i = 1; i < n; i++) {
      int last = nums[i - 1];
      if (last > 0) {
        nums[i] += nums[i - 1];
      }
      max = Math.max(nums[i], max);
    }
    return max;
  }
}
