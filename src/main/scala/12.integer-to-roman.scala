object Q12 {
  def intToRoman(num: Int): String = {
    val map = Seq[(Int, String)](
      1000 -> "M",
      900 -> "CM",
      500 -> "D",
      400 -> "CD",
      100 -> "C",
      90 -> "XC",
      50 -> "L",
      40 -> "XL",
      10 -> "X",
      9 -> "IX",
      5 -> "V",
      4 -> "IV",
      1 -> "I"
    )
    @scala.annotation.tailrec
    def loop(num: Int, map: Seq[(Int, String)], acc: String): String = {
      (num, map) match {
        case (0, _) | (_, Nil) => acc
        case (n: Int, (h: Int, s: String) :: t) =>
          // 如果当前值大了, 则继续往后面找
          if (n < h) loop(n, t, acc)
          // 如果当前值合适, 则从头找, 继续往后面找的话会把钱打散, 导致leetcode判定不正确
          // 比如20 正确的答案应该是XX, 这里如果继续往后面找会变成 XIXI
          else loop(n - h, map, acc + s)
      }
    }
    loop(num, map, "")
  }
}
