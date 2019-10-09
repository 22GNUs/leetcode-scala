object Q70 {
  def climbStairs(n: Int): Int =
    if (n == 1) 1
    else if (n == 2) 2
    else climbStairs(n - 1) + climbStairs(n - 2)
}
