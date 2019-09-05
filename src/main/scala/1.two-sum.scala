object Q1 {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    // group by -> key -> [(key, i)]
    // 可以处理 (3, 3) 这种一个value对应多个index的情况
    val map = nums.zipWithIndex.groupBy(_._1)
    nums.zipWithIndex
      .filter {
        case (v, i) =>
          val diff = target - v
          map.contains(diff) && map(diff).exists(_._2 != i)
      }
      .map(_._2)
  }
}
