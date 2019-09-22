object Solution {
  def letterCombinations(digits: String): List[String] = {
    def group: (String, String) => List[String] = { (s1, s2) =>
      for {
        c1 <- s1.toList
        c2 <- s2
      } yield "" + c1 + c2
    }

    val map = Map[Char, String](
      '2' -> "abc",
      '3' -> "def",
      '4' -> "ghi",
      '5' -> "jkl",
      '6' -> "mne",
      '7' -> "pqrs",
      '8' -> "tuv",
      '9' -> "wxyz"
    )

    if (digits.isEmpty) Nil
    else if (digits.length == 1) digits.flatMap(map(_)).map("" + _).toList
    else {
      val chars: Seq[(String, String)] = for {
        i <- 1 until digits.length
        j <- 0 until i
      } yield (map(digits(j)), map(digits(i)))

      chars.flatMap(group.tupled(_)).toList
    }
  }
}
