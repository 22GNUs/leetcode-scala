object Q3 {
  def lengthOfLongestSubstring(s: String): Int = {
    def findNonRepeat(s: String, acc: String): Int = {
      if (s.isEmpty) acc.length
      else {
        if (acc.contains(s.head)) acc.length
        else findNonRepeat(s.tail, s.head +: acc)
      }
    }
    def loop(s: String, max: Int): Int = {
      if (s.isEmpty) max
      else {
        lazy val x = findNonRepeat(s, "")
        loop(s.tail, if (x > max) x else max)
      }
    }
    loop(s, 0)
  }

}
