object Q13 {
  def romanToInt(s: String): Int = {
    val m = Map[Char, Int](
      'I' -> 1,
      'V' -> 5,
      'X' -> 10,
      'L' -> 50,
      'C' -> 100,
      'D' -> 500,
      'M' -> 1000
    )
    @scala.annotation.tailrec
    def loop(s: String, acc: Int): Int = {
      if (s.isEmpty) acc
      else if (s.length == 1) {
        acc + m(s.head)
      } else {
        val curr = s.head
        val next = s.tail.head
        (curr, next) match {
          case t @ (('I', 'V') | ('I', 'X') | ('X', 'L') | ('X', 'C') |
              ('C', 'D') | ('C', 'M')) =>
            loop(s.tail.tail, acc + m(t._2) - m(t._1))
          case (x, _) => loop(s.tail, acc + m(x))
        }
      }
    }
    loop(s, 0)
  }
}
