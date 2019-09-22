object Q22 {
  def generateParenthesis(n: Int): List[String] = {

    var ret = List.empty[String]

    /**
      * 内层循环, 生成答案
      * @param open 剩余左括号数量
      * @param close 剩余右括号数量
      * @param curr 当前的字符串
      */
    def loop(
        open: Int,
        close: Int,
        curr: String
    ): Unit =
      // 修改if-else的earlyreturn策略会改变递归顺序, 导致结果不正确
      // 右边比左边用的多了则说明不对
      if (close < open) ()
      else {
        if (open == 0 && close == 0) ret :+= curr
        if (open > 0) loop(open - 1, close, curr + '(')
        if (close > 0) loop(open, close - 1, curr + ')')
      }
    loop(n, n, "")
    ret
  }
}
