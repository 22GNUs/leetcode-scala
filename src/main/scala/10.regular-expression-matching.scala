object Solution {
  @scala.annotation.tailrec
  def isMatch(s: String, p: String): Boolean = {
    // 定义一个object模式匹配string
    object +: {
      def unapply(arg: String): Option[(Char, String)] = arg.headOption.map {
        (_, arg.tail)
      }
    }
    (s, p) match {
      // 通配符后一位带 '*' 的情况
      case (str @ sh +: sl, pattern @ ph +: '*' +: pl) =>
        if (sh == ph) isMatch(sl, pattern) else isMatch(str, pl)
      // 通配符 '.' 的情况
      case (_ +: sl, '.' +: pl) => isMatch(sl, pl)
      // 常规情况
      case (sh +: sl, ph +: pl)             => (sh == ph) && isMatch(sl, pl)
      case (str, pattern) if str == pattern => true
      case _                                => false
    }
  }
}
