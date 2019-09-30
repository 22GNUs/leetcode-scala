object Q20 {
  def isValid(s: String): Boolean =
    if (s.isEmpty) true
    else {
      val map = Map[Char, Char](')' -> '(', '}' -> '{', ']' -> '[')
      @scala.annotation.tailrec
      def loop(s: String, stack: List[Char]): Boolean =
        if (s.isEmpty) stack.isEmpty
        else {
          val h = s.head
          // 遇到尾, 如果匹配则出栈
          if (map.contains(h)) {
            if (stack.headOption.contains(map(h))) loop(s.tail, stack.tail)
            // 没有匹配则直接返回false
            else false
          } // 其他情况, 入栈
          else loop(s.tail, h +: stack)
        }
      loop(s, Nil)
    }
}
