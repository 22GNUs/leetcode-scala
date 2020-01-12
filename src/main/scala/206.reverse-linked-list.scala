/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  * 思路:
  * <pre>
  * 例子: 1 -> 2 -> 3 -> 4
  *
  * 先反转 (2 -> 3 -> 4) 再把1放到末尾
  * 原先的想法是遍历 (4 -> 3 -> 2) 再把2接上1
  * 题解的巧妙方法是把它看成1 -> (2 <- 3 <- 4)
  * 这样只需要把 1.next.next(2.next, 此时应该为null) 重新指回到1就可以了
  * </pre>
  */
object Q206Rec {
  def reverseList(head: ListNode): ListNode =
    if (head == null) null
    else if (head.next == null) head
    else {
      val rev = reverseList(head.next)
      // 关键点
      head.next.next = head
      head.next = null
      rev
    }
}
