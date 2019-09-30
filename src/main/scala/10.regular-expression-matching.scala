object Q10 {
  def isMatch(s: String, p: String): Boolean = {
    // 定义一个object模式匹配string
    object +: {
      def unapply(arg: String): Option[(Char, String)] = arg.headOption.map {
        (_, arg.tail)
      }
    }
    (s, p) match {
      case ("", "") => true
      // 通配符后一位带 '*' 的情况
      case ("", _ +: '*' +: pl)                        => isMatch("", pl)
      case (str @ sh +: sl, pattern @ ph +: '*' +: pl) =>
        // 貌似没想到优化成尾递归的方法
        isMatch(str, pl) || (sh == ph || ph == '.') && isMatch(sl, pattern)
      // 通配符 '.' 的情况
      case (_ +: sl, '.' +: pl) => isMatch(sl, pl)
      // 常规情况
      case (sh +: sl, ph +: pl) => (sh == ph) && isMatch(sl, pl)
      // 剩下就是pattern为""的情况
      case _ => false
    }
  }
}
