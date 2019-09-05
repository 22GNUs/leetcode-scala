/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}
object Q2 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var acc: ListNode = null
    var init: ListNode = null
    var carry = 0
    @scala.annotation.tailrec
    def loop(l1: ListNode, l2: ListNode): ListNode = {
      if (l1 == null && l2 == null) {
        return init
      }
      val ls1 = if (l1 == null) new ListNode(0) else l1
      val ls2 = if (l2 == null) new ListNode(0) else l2
      val sum = carry + ls1._x + ls2._x
      val curr = new ListNode(sum % 10)
      carry = sum / 10

      if (acc == null) acc = curr
      else {
        acc.next = curr
        acc = acc.next
      }
      if (init == null) init = curr
      loop(ls1.next, ls2.next)
    }
    val ret = loop(l1, l2)
    // 如果还有进位, 则也要把进位加上
    if (carry > 0) {
      acc.next = new ListNode(carry)
    }
    ret
  }
}
