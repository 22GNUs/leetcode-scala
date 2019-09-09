/**
  * 暴力解法
  */
object Q3BruteForce {
  def lengthOfLongestSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def findNonRepeat(s: String, acc: String): Int = {
      if (s.isEmpty) acc.length
      else {
        if (acc.contains(s.head)) acc.length
        else findNonRepeat(s.tail, s.head +: acc)
      }
    }
    @scala.annotation.tailrec
    def loop(s: String, max: Int): Int = {
      if (s.isEmpty) max
      else {
        val x = findNonRepeat(s, "")
        loop(s.tail, if (x > max) x else max)
      }
    }
    loop(s, 0)
  }

}

/**
  * 滑动窗口解法, 通过一个list维护当前的窗口
  * 窗口最终的最大值就是连续子串最大值
  * 使用list的版本性能会比使用set的版本差一些, 但是这样fp呀
  */
object Q3SlideWindow {
  def lengthOfLongestSubstring(s: String): Int = {
    @scala.annotation.tailrec
    def loop(s: String, window: List[Char], acc: Int): Int = {
      if (s.isEmpty) acc
      else {
        val h = s.head
        // 注意点是这里的第一个参数是s而不是s.tail
        // 因为遇到已存在的情况有可能需要多次删除而不是只删除一次
        // 也就是这个原因导致这里可能有2n的复杂度
        // list的contains方法复杂度也是O(n), 所以要性能完美的话还是需要set+索引的方式
        if (window.contains(h)) loop(s, window.tail, acc)
        else {
          val ns = window :+ h
          loop(s.tail, ns, Math.max(ns.size, acc))
        }
      }
    }
    loop(s, List[Char](), 0)
  }

}
