/**
  * 思路: 首先通过二分查找找出旋转下标
  * 再用二分查找查询target
  */
object Q33 {
  def search(nums: Array[Int], target: Int): Int =
    if (nums.length == 0) -1
    else if (nums.length == 1) if (nums(0) == target) 0 else -1
    else {
      // 二分查找
      @scala.annotation.tailrec
      def bs(l: Int, r: Int): Int =
        if (l > r) -1
        else {
          val mid = l + (r - l) / 2
          if (nums(mid) == target) mid
          else if (nums(mid) > target) bs(l, mid - 1)
          else bs(mid + 1, r)
        }

      @scala.annotation.tailrec
      def findIdx(l: Int, r: Int): Int =
        // 不能包含=
        if (l > r) -1
        else {
          val mid = l + (r - l) / 2
          println(mid)
          if (nums(mid) > nums(mid + 1)) mid + 1
          // 要注意区间问题, 相等的情况下还是要继续往右边找
          // 例子: 8, 9, 2, 3, 4; 查到8的时候自己跟自己相等, 这个时候还需要去找9
          else if (nums(mid) < nums(l)) findIdx(l, mid - 1)
          else findIdx(mid + 1, r)
        }

      val end = nums.length - 1
      // 找到旋转位置
      val idx = if (nums(0) < nums(end)) -1 else findIdx(0, end)
      if (idx == -1) bs(0, end)
      // 这里要注意考虑相等的情况下分配到哪边
      else if (nums(0) > target) bs(idx, end)
      else bs(0, idx - 1)
    }
}
