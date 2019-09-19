/**
 * 求数组的最大度, 找到对应的数字, 再找这个数字的最大范围
 */
object Solution {
  def findShortestSubArray(nums: Array[Int]): Int = {
    val maxDegreeNum = nums.groupBy(identity).maxBy{ case (_, lst) => lst.length }._1
    // FIXME 在有两个数字的degree都等于最大degree的时候会出错
    nums.length - nums.reverse.indexOf(maxDegreeNum) - nums.indexOf(maxDegreeNum)
  }
}
