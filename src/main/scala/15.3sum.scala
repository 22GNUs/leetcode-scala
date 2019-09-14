/**
  * 答案是正确的, 最后超时了没有ac, 指针还是不太适合scala 囧
  * 改用java实现了 @see Q15Java...
  * 参考https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
  */
object Q15 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.length < 3) Nil
    else {
      val sort = nums.sorted
      val len = nums.length
      @scala.annotation.tailrec
      def loop(i: Int,
               l: Int,
               r: Int,
               acc: List[List[Int]]): List[List[Int]] = {
        if (i >= len - 1) acc
        // l > r 表示这轮循环没有找到合适的值, 增大i并清空l, r继续下一轮
        // sort(i) == sort(i - 1) 表示这轮的值跟上一轮是一样的, 没必要接着找了, 继续下一轮
        else if (l >= r || (i > 0 && sort(i) == sort(i - 1)))
          loop(i + 1, i + 2, len - 1, acc)
        else {
          // 从小到大排列, 如果三个数的第一个已经大于0了, 则和不可能为0
          if (sort(i) > 0) loop(i + 1, i + 2, len - 1, acc)
          else {
            val ret = sort(i) + sort(l) + sort(r)
            if (ret == 0) {
              // 结果等于0, 则移动l和r继续找
              // 如果后面的值跟l或者r是一样的, 则直接移动到不重合的位置
              val newL = {
                var tmp = l
                while (tmp < r && sort(tmp) == sort(l)) tmp += 1
                tmp
              }
              val newR = {
                var tmp = r
                while (tmp < r && sort(tmp) == sort(r)) tmp -= 1
                tmp
              }
              loop(i, newL, newR, acc :+ List(sort(i), sort(l), sort(r)))
              // 值太大了, 把右边左移, 让值变小
            } else if (ret > 0) loop(i, l, r - 1, acc)
            // 值太小了, 把左边右移, 让值变大
            else loop(i, l + 1, r, acc)
          }
        }
      }

      loop(0, 1, len - 1, List.empty[List[Int]])
    }

  }
}
