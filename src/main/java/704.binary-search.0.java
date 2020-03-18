class Q704V1 {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        // 大了往左移
        r = mid;
      } else {
        // 小了往右移
        l = mid + 1;
      }

    }
    return -1;
  }
}
