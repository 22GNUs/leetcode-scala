class Q724 {
  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int sum = 0;
    // 先循环求一次和, 可以省略掉后面的求和步骤
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    for (int j = 0; j < nums.length; j++) {
      int curr = nums[j];
      if (left == sum - left - curr) {
        return j;
      }
      left += curr;
    }
    return -1;
  }
}
