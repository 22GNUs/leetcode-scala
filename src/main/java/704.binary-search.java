class Q704 {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }
}
