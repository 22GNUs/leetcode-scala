object Q1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def loop(idx: Int, map: Map[Int, Int]): Array[Int] =
      if (nums.isEmpty || idx >= nums.length) Array.emptyIntArray
      else {
        val h = nums(idx)
        val c = target - h
        if (map.contains(c)) Array(map(c), idx)
        else loop(idx + 1, map + (h -> idx))
      }
    loop(0, Map.empty[Int, Int])
  }
}
