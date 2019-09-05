import org.scalatest.{Matchers, WordSpec}

/**
  *@author wangxinhua
  *@since 1.0
  */
class SolutionTest extends WordSpec with Matchers {
  "two sum test case" in {
    val ret = Q1.twoSum(Array(3, 3), 6)
    ret should ===(Array(0, 1))
  }

  "add two number test case" in {
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

}
