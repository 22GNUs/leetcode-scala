/**
  * 思路: 利用二分搜索找到对应的值之后再往前后移动到最左和最右的位置
  */
object Q34 {
  def searchRange(nums: Array[Int], target: Int): Array[Int] =
    if (nums.length == 0) Array(-1, -1)
    else if (nums.length == 1) if (nums(0) == target) Array(0, 0) else Array(-1, -1)
    else {
      @scala.annotation.tailrec
      def bs(l: Int, r: Int): Int =
        if (l > r) -1
        else {
          val mid = l + (r - l) / 2
          if (nums(mid) == target) mid
          else if (nums(mid) < target) bs(mid + 1, r)
          else bs(l, mid - 1)
        }

      val idx = bs(0, nums.length - 1)
      if (idx == -1) Array(-1, -1)
      else {
        var (l, r) = (idx, idx)
        while (l > 0 && nums(l - 1) == nums(l)) l -= 1
        while (r < nums.length - 1 && nums(r + 1) == nums(r)) r += 1
        Array(l, r)
      }
    }
}
