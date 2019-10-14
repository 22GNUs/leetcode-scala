/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Q24Rec {
    import common.ListNode
    def swapPairs(head: ListNode): ListNode = {
      if (head == null || head.next == null) head       
      else {
        val next = head.next
        head.next = swapPairs(next.next)
        next.next = head
        next
      }
    }
}
