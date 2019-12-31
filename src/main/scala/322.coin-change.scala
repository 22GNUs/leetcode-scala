object Q322Rec1 {
  def coinChange(coins: Array[Int], amount: Int): Int =
    if (amount == 0) 0
    else {
      @scala.annotation.tailrec
      def loop(i: Int, ret: Int): Int =
        if (i == coins.length) ret
        else {
          val coin = coins(i)
          val next = amount - coin
          if (next < 0) ret
          else {
            val nextRet = coinChange(coins, next)
            if (nextRet == -1) ret
            else loop(i + 1, Math.min(ret, nextRet + 1))
          }
        }
      val ret = loop(0, Int.MaxValue)
      if (ret == Int.MaxValue) -1 else ret
    }
}

object Q322Rec2 {
  def coinChange(coins: Array[Int], amount: Int): Int =
    if (amount == 0) 0
    else {
      coins
        .map(amount - _)
        .filter(_ >= 0)
        .map(coinChange(coins, _) + 1)
        .reduceOption(_ min _)
        .filter(_ > 0)
        .getOrElse(-1)
    }

}
