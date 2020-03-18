/**
 * 思路:
 * 利用双指针, 当p != q 时把不相等的部分挪到数组的前半部分
 */
object Q26Scala {
  def removeDuplicates(nums: Array[Int]): Int =
    if (nums.length == 0) 0
    else {
      @scala.annotation.tailrec
      def loop(p: Int, q: Int): Int =
        if (q == nums.length) p + 1
        else if (nums(p) != nums(q)) {
          nums(p + 1) = nums(q)
          loop(p + 1, q)
        } else loop(p, q + 1)
      loop(0, 1)
    }
}
