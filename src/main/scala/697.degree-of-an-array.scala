/**
  * 求数组的最大度, 找到对应的数字, 再找这个数字的最大范围
  */
object Q697 {
  def findShortestSubArray(nums: Array[Int]): Int = {
    val reversed = nums.reverse
    def lengthOfNum(num: Int): Int =
      (nums.length - reversed.indexOf(num)) - nums.indexOf(num)

    // groupBy后求度最大的数字的长度, 如果有多个度最大的数字则取长度最小的
    nums
      .groupBy(identity)
      .map { case (k, v) => k -> v.length }
      .groupBy(_._2)
      .maxBy(_._1)
      ._2
      .keys
      .map(lengthOfNum)
      .min
  }
}
