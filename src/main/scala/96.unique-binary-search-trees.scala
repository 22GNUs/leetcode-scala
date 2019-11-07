/**
  * Q96递归
  * 每一轮把左边的子树个数乘以右边的子树个数
  * 因为二叉搜索树要求左边必须小于i, 右边必须大于i
  * 所以
  * 左边 -> i - 1
  * 右边 -> n - i
  */
object Q96Rec {
  def numTrees(n: Int): Int =
    if (n <= 1) 1
    else
      (1 to n).foldLeft(0) { (acc, item) =>
        acc + numTrees(item - 1) * numTrees(n - item)
      }
}

/**
  * Q96 动态规划
  */
object Q96DP {
  def numTrees(n: Int): Int = {
    val dp = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    (2 to n).foreach { i =>
      (1 to i).foreach { j =>
        dp(i) += dp(j - 1) * dp(i - j)
      }
    }
    dp(n)
  }
}
