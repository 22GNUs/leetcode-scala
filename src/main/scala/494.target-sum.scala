object Q494Rec {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    var ret = 0;
    def dfs(i: Int, sum: Int): Unit =
      if (i == nums.length) {
        if (sum == S) ret += 1
      } else {
        dfs(i + 1, sum + nums(i))
        dfs(i + 1, sum - nums(i))
      }
    dfs(0, 0)
    ret
  }
}
