object Q7 {
  def reverse(x: Int): Int = {
    // 第二个参数用Long来处理溢出
    @scala.annotation.tailrec
    def loop(x: Int, ret: Long): Int =
      if (x == 0) ret.intValue
      else {
        // 溢出
        if (ret > Int.MaxValue / 10 || ret < Int.MinValue / 10) loop(0, 0)
        // 每一轮循环把前一个值 * 10 再加上现在抛出来的值
        // 例如123: (123, 0) -> (12, 3) -> (1, 32) -> (0, 321) -> 321
        else loop(x / 10, ret * 10 + x % 10)
      }
    loop(x, 0)
  }
}
