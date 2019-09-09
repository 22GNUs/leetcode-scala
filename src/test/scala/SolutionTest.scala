import org.scalatest.{Matchers, WordSpec}

/**
  *@author wangxinhua
  *@since 1.0
  */
class SolutionTest extends WordSpec with Matchers {
  "1.two-sum test case" in {
    val ret = Q1.twoSum(Array(3, 3), 6)
    ret should ===(Array(0, 1))
  }

  "2.add-two-numbers test case" in {
    def buildNode(args: Int*): ListNode = args.toList match {
      case Nil => null
      case x :: xs =>
        val n = new ListNode(x)
        n.next = buildNode(xs: _*)
        n
    }
    def toList(n: ListNode): List[Int] = {
      if (n == null)
        Nil
      else
        n._x :: toList(n.next)
    }
    val ret = Q2.addTwoNumbers(buildNode(1), buildNode(9, 9))
    val lst = toList(ret)
    println(lst)
    lst should ===(List(7, 0, 8))
  }

  "3.longest-substring-without-repeating-characters test case" in {
    val testMap = Map("dvdf" -> 3, "abcabc" -> 3)
    for ((a, s) <- testMap) {
      val ret = Q3SlideWindow.lengthOfLongestSubstring(a)
      println(s"$a -> $s")
      ret should ===(s)
    }
  }

  "5.longest-palindromic-substring test case" in {
    val testMap = Map("a" -> "a")
    for ((a, s) <- testMap) {
      val ret = Q5.longestPalindrome(a)
      println(s"$a -> $s")
      ret should ===(s)
    }
  }

}
