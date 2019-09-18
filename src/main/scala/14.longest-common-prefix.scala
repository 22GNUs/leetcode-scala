/**
  * 垂直扫描法
  * 用两层循环来处理, i表示纵向切面
  * j 表示横向切面
  * 每一次go调用则把纵向切面往前面挪一遍, 如果array的该索引位置都有值且相等,则加入到答案
  */
object Q14Vertical {
  def longestCommonPrefix(strs: Array[String]): String = {

    /**
      * 控制竖相切面
      */
    @scala.annotation.tailrec
    def go(i: Int, acc: String): String = {

      /**
        * 控制横向切面
        */
      @scala.annotation.tailrec
      def extract(j: Int, c: Option[Char]): Option[Char] = {
        if (j >= strs.length) c
        else {
          val s = strs(j)
          if (i >= s.length) None
          else {
            c match {
              case None => extract(j + 1, Some(s(i)))
              case Some(last) =>
                if (last == s(i)) extract(j + 1, c)
                else None
            }
          }
        }
      }
      // 横向切面循环, 每次获取一个头进行比较,如果多个list在i位置都相等则返回
      // 用递归是为了解决early return的问题
      extract(0, None) match {
        case None    => acc
        case Some(c) => go(i + 1, acc + c)
      }
    }
    go(0, "")
  }
}

/**
  * 由于多个方法都依赖该方法, 所以抽出来, 单独提交可以定义在方法内
  */
private object Helper {
  @scala.annotation.tailrec
  def longestCommon(s1: String, s2: String): String =
    // indexOf == 0是关键,必须在首部匹配才是对的
    if (s1.isEmpty || s2.indexOf(s1) == 0) s1
    else longestCommon(s1.slice(0, s1.length - 1), s2)
}

/**
  * 水平扫描法
  * 每次循环判断是否有重合, 没有重合则把s1截取一位后再判断
  */
object Q14Horizontal {
  import Helper._
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) "" else strs.reduce(longestCommon)
  }
}

/**
  * 分治法
  */
object Q14Split {
  import Helper._
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) ""
    else if (strs.length == 1) strs(0)
    else if (strs.length == 2) longestCommon(strs(0), strs(1))
    else {
      val (left, right) = strs.splitAt(strs.length / 2)
      longestCommon(longestCommonPrefix(left), longestCommonPrefix(right))
    }
  }
}
