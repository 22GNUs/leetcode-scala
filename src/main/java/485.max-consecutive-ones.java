class Q485 {
  public int findMaxConsecutiveOnes(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int k = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        max = Math.max(max, i - k + 1);
        continue;
      }
      k = i + 1;
    }
    return max;
  }
}
