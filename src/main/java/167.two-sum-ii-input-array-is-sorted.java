class Q167 {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    while (i < numbers.length && j >= 0) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[] { i + 1, j + 1 };
      }
      // 太大了, 把大的挪小
      if (sum > target) {
        j--;
      } else {
        // 太小了, 把小的挪大
        i++;
      }
    }
    return new int[] { -1, -1 };
  }
}
