/**
  * 高阶函数解法
  */
object Q17HighOrder {
  def letterCombinations(digits: String): List[String] = {
    val map = Map[Char, String](
      '2' -> "abc",
      '3' -> "def",
      '4' -> "ghi",
      '5' -> "jkl",
      '6' -> "mno",
      '7' -> "pqrs",
      '8' -> "tuv",
      '9' -> "wxyz"
    )
    // 每次把当前的值跟新的字母做一次for yield, 生成新的list
    digits.view.map(map(_).map(_.toString)).foldLeft(List.empty[String]) {
      (acc, item) =>
        if (acc.isEmpty) item.toList
        else acc.flatMap(s => item.map(s + _))
    }
  }
}

/**
  * 递归解法
  */
object Q17Rec {
  def letterCombinations(digits: String): List[String] = {
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

    /**
      * 原理同foldLeft
      */
    @scala.annotation.tailrec
    def loop(digits: String, acc: List[String]): List[String] = {
      if (digits.isEmpty) acc
      else {
        // 获取一个数字
        val number = digits.head
        val target = map(number).map(_.toString)
        if (acc.isEmpty) {
          loop(digits.tail, target.toList)
        } else {
          val next = for {
            c1 <- acc
            c2 <- target
          } yield c1 + c2
          loop(digits.tail, next)
        }
      }
    }
    loop(digits, List.empty[String])
  }
}
