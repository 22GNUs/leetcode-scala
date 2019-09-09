/**
  * 动态规划实现最长回文串
  */
object Q5 {
  def longestPalindrome(s: String): String = {
    val len = s.length
    var res = ""
    if (len != 0) {
      // dp缓存数组
      val dp = Array.ofDim[Boolean](len, len)
      for (r <- 0 until len) {
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
