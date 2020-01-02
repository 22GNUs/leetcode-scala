/**
 * 思路:
 * 
 * <pre>
 * 正常情况(不考虑负数)
 * f(i) = Math.max(f(i), f(i) * f(i - 1))
 * 如果出现负数, 则f(i - 1)需要需要取最小值, 此时程序才能取到最大值
 * 因此需要swap
 * </pre>
 */
class Q152 {
  public int maxProduct(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return nums[0];
    }
    int max = nums[0], min = nums[0], ret = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] < 0) {
        // 位运算swap
        max = max ^ min;
        min = max ^ min;
        max = max ^ min;
      }
      max = Math.max(nums[i], max * nums[i]);
      min = Math.min(nums[i], min * nums[i]);
      ret = Math.max(max, ret);
    }
    return ret;
  }
}
