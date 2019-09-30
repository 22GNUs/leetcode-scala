object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    def maxSum(start: Int, end: Int): Int = {
      (start to end).map(nums(_)).sum
    }
    def loop(start: Int, end: Int): Int = {
      val mid = (start + end) / 2
      val left = maxSum(start, mid)
      val right = maxSum(mid, end)
    }
  }
}
