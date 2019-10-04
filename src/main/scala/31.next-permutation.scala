object Q31 {
  def nextPermutation(nums: Array[Int]): Unit = {
    def swap(i: Int, j: Int): Unit = {
      val tmp = nums(j)
      nums(j) = nums(i)
      nums(i) = tmp
    }
    val len = nums.length
    def reverse(from: Int): Unit = {
      var (i, j) = (from, len - 1)
      while (i < j) {
        swap(i, j)
        i += 1
        j -= 1
      }
    }
    var i = len - 2
    // 找到第一个降序数位置
    // 注意这个等号是要包含在里面的, 不能替换为 nums(i) < nums(i + 1), 因为遇到相等的也是要继续找的
    while (i >= 0 && nums(i + 1) <= nums(i)) i -= 1
    if (i < 0) reverse(0)
    else {
      var j = len - 1
      // 找到第一个比i大的值
      while (j > 0 && nums(j) <= nums(i)) j -= 1
      swap(i, j)
      reverse(i + 1)
    }
  }
}
