object Q557Lazy {
  def reverseWords(s: String): String =
    s.split(" ").map(_.reverse).mkString(" ")
}
