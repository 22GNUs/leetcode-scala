object Q151Lazy {
  def reverseWords(s: String): String =
    s.trim.split(" +").reverse.mkString(" ")
}
