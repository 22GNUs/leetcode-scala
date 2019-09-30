/**
  * 这道题的关键是找规律
  * 参考: https://www.youtube.com/watch?v=re-WQ14s-Kg
  */
object Q6 {
  def convert(s: String, numRows: Int): String =
    if (numRows == 1 || numRows >= s.length) s
    else {
      var (row, step) = (0, 1)
      // 初始化一个以row为座标, string为元素的数组
      lazy val empStr: String = ""
      val arr: Array[String]  = Array.fill[String](numRows)(empStr)
      for (c <- s) {
        // 按行数更新
        arr(row) = arr(row) + c
        // 核心代码, 控制把字符插入到哪一行
        if (row == 0) step = 1
        else if (row == numRows - 1) step = -1

        row += step
      }
      arr.mkString(empStr)
    }
}
