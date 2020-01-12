import common.scala.ListNode

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Q24Rec {
    def swapPairs(head: ListNode): ListNode = {
      if (head == null || head.next == null) head       
      else {
        val next = head.next
        // 如果只是交换两个节点则这里的代码是
        // head.next = next.next
        // 再递归的把next.next做交换就是答案
        head.next = swapPairs(next.next)
        next.next = head
        next
      }
    }
}
