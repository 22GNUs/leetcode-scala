class Q747 {
  public int dominantIndex(int[] nums) {
    if (nums.length == 0) {
      return -1;
    }
    int max = Integer.MIN_VALUE;
    int maxIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIdx = i;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == maxIdx) {
        continue;
      }
      if (nums[i] * 2 > max) {
        return -1;
      }
    }
    return maxIdx;
  }
}
