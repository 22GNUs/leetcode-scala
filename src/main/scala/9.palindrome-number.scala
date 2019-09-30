/**
  * 判断一个数字是否是回文
  * 核心逻辑是: 只要判断后半部分跟前半部分是否相等就可以
  * 比如: 1212 只需要判断12 == 12则可以确定是回文
  * 如果是奇数, 则判断后半部分 / 10 与前半部分相等, 因为奇数中间位不需要判断
  */
object Q9 {
  def isPalindrome(x: Int): Boolean =
    // 两种特殊情况
    // 0 或者最后一位为0且不为0的数
    if (x < 0 || (x % 10 == 0 && x != 0)) false
    else {
      @scala.annotation.tailrec
      def revert(s: Int, r: Int): (Int, Int) =
        if (r >= s) (s, r) else revert(s / 10, r * 10 + s % 10)
      // 提取出左半部分和右半部分
      val (left, right) = revert(x, 0)
      left == right || left == right / 10
    }
}
