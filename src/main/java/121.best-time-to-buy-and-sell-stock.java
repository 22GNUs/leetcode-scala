/**
 * 一次遍历, 原理为求出波峰和波谷的差值
 */
class Q121 {
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int ret = 0;
    // 因为要求的值肯定需要后面比前面小, 所以波谷肯定在前面, 波峰在后面
    for (int i = 0; i < prices.length; i++) {
      min = Math.min(min, prices[i]);
      if (prices[i] - min > ret) {
        ret = prices[i] - min;
      }
    }
    return ret;
  }
}
