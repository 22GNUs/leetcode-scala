object Q202Scala {
  def isHappy(n: Int): Boolean = {
    @scala.annotation.tailrec
    def loop(n: Int, set: Set[Int]): Boolean = n match {
      case 1                    => true
      case s if set.contains(s) => false
      case s =>
        @scala.annotation.tailrec
        def sum(n: Int, acc: Int): Int =
          if (n == 0) acc
          else {
            val x = n % 10
            sum(n / 10, acc + x * x)
          }
        loop(sum(s, 0), set + s)
    }
    loop(n, Set())
  }
}
