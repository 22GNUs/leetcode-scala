// 递归
object Q70 {
  def climbStairs(n: Int): Int =
    if (n == 1) 1
    else if (n == 2) 2
    else climbStairs(n - 1) + climbStairs(n - 2)
}

// 递归 + 缓存
object Q70Memo {
  def climbStairs(n: Int): Int = {
    var memo = Map.empty[Int, Int]
    def loop: Int => Int = {
      case 1 => 1
      case 2 => 2
      case n =>
        if (memo.contains(n)) memo(n)
        else {
          val ret = loop(n - 1) + loop(n - 2)
          memo += (n -> ret)
          ret
        }
    }
    loop(n)
  }
}

// 尾递归版本
// 利用规律, 每一个后层楼梯的值等于前面两层的和
// 类似Fib
object Q70TailRec {
  def climbStairs(n: Int): Int = {
    @scala.annotation.tailrec
    def loop(i: Int, first: Int, second: Int): Int = i match {
      case i if i > n  => n
      case i if i == n => first + second
      case i           => loop(i + 1, second, first + second)
    }
    loop(3, 1, 2)
  }
}
