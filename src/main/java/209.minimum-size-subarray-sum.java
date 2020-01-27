/**
 * 思路:
 * <pre>
 * 维护一个滑动窗口, 窗口内部的值sum肯定为当前满足条件的最小值
 * left表示当前满足条件的窗口的左边界
 * (i - left) + 1则为当前满足条件的边界的值
 * </pre>
 */
class Q209 {
  public int minSubArrayLen(int s, int[] nums) {
    int min = Integer.MAX_VALUE;
    // 滑动窗口的总大小
    int sum = 0;
    // 窗口左边索引
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i] + sum;
      if (value >= s) {
        // 增大窗口
        // 窗口值满足条件时尝试缩小窗口
        while (value - nums[left] >= s) {
          value -= nums[left++];
        }
        min = Math.min(min, i - left + 1);
      }
      sum = value;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
