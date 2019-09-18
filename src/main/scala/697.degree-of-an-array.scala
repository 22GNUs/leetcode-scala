object Solution {
    def findShortestSubArray(nums: Array[Int]): Int = {
      val init = (List.empty[Int], 50000)       
      nums.foldLeft(init) {
        case ((Nil, _), item) => (List(item), 1)
        case ((lst @ h :: _, size), item) =>
          if (item != h) (List(item), 1) else (item +: lst, Math.min(size, lst.length + 1))
    }._2
}
