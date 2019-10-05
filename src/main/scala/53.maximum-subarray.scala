object Q53 {
  def maxSubArray(nums: Array[Int]): Int = {
    var sum = 0
    if (nums.length == 0) sum
    else
      nums.fold(nums.head) { (acc, item) =>
        sum = if (sum > 0) sum + item else item
        Math.max(sum, acc)
      }
  }
}