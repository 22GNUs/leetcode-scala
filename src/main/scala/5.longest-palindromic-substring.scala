/**
  * 动态规划实现最长回文串
  */
object Q5DP {
  def longestPalindrome(s: String): String = {
    val len = s.length
    var res = ""
    if (len != 0) {
      // dp缓存数组
      val dp = Array.ofDim[Boolean](len, len)
      // until 右边不闭合
      for (r <- 0 until len) {
        // to 右边闭合
        for (l <- 0 to r) {
          if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp(l + 1)(r - 1))) {
            dp(l)(r) = true
            val curLen = r - l + 1
            if (curLen > res.length) {
              res = s.substring(l, r + 1)
            }
          }
        }
      }
    }
    res
  }
}

/**
  * fp风格的暴力法, 无法通过测试
  * 参考:
  * https://stackoverflow.com/questions/15253591/scala-laziness-how-to-get-rid-of-return-statement-in-this-palindrome-search
  */
object Q5BruteForce {
  def longestPalindrome(s: String): String = {
    (for {
      substrSize <- s.length to 1 by -1
      // sliding生成多个窗口, 对切割好的窗口再迭代返回
      substr <- s.sliding(substrSize)
      if substr == substr.reverse
      // 因为是倒序遍历, 所以前面的肯定是更长的字串
    } yield substr).headOption.getOrElse("")
  }
}
