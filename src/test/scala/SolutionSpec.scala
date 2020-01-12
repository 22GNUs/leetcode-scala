import common.scala.ListNode
import org.scalatest.{ Matchers, WordSpec }

/**
  *@author wangxinhua
  *@since 1.0
  */
class SolutionSpec extends WordSpec with Matchers {
  "1.two-sum test case" in {
      val ret = Q1.twoSum(Array(2, 7, 11, 15), 9)
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
      def toList(n: ListNode): List[Int] =
        if (n == null)
          Nil
        else
          n._x :: toList(n.next)
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
      multiAssert(Map("abcab" -> "abc"), Q5DPJava.longestPalindrome)
    }

  "6.zigzag-conversion test case" in {
      multiAssert(Map("LEETCODEISHIRING" -> "LCIRETOESIIGEDHN"), Q6.convert(_, 3))
    }

  "7.reverse-integers test case" in {
      multiAssert(Map(123 -> 321), Q7.reverse)
    }

  "9.palindrome-number test case" in {
      multiAssert(Map(121 -> true, 12321 -> true, 123 -> false), Q9.isPalindrome)
    }

  "10.regular-expression-matching test case" in {
      Q10.isMatch("ab", ".*") should ===(true)
    }

  "12.integer-to-roman" in {
      Q12.intToRoman(20) should ===("XX")
    }

  "14.longest-common-prefix - Vertical" in {
      val ret = Q14Vertical.longestCommonPrefix(Array("aa", "a"))
      ret should ===("a")
    }

  "14.longest-common-prefix - Horizontal" in {
      val ret = Q14Horizontal.longestCommonPrefix(Array("c", "acc", "ccc"))
      ret should ===("")
    }

  "14.longest-common-prefix - Split" in {
      val ret = Q14Split.longestCommonPrefix(Array("c", "acc", "ccc"))
      ret should ===("")
    }

  "17.letter-combinations-of-a-phone-number.scala" in {
      val ret = Q17HighOrder.letterCombinations("23")
      ret should ===(List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }

  "15.3sum" in {
      val ret = Q15.threeSum(Array(0, 0, 0))
      ret should ===(List(List(0, 0, 0)))
    }

  "20.valid-parentheses" in {
      val ret = Q20.isValid("\"]\"")
      ret shouldBe false
    }

  private def multiAssert[K, V](kv: Map[K, V], f: K => V): Unit =
    for ((a, s) <- kv) {
      val ret = f(a)
      println(s"$a -> $s")
      ret should ===(s)
    }

}
