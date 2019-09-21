/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Q21 {
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {       
      // r 最后的结果
      // t 维护当前的链表节点
      var (t1, t2, r, t): (ListNode, ListNode, ListNode, ListNode) = (l1, l2, null, null)
      while (t1 != null || t2 != null) {
        // 两个节点里面取小的那个
        var minNode: ListNode = null
        if (t1 == null) { minNode = t2; t2 = t2.next }
        else if (t2 == null) { minNode = t1; t1 = t1.next }
        else {
          if (t1.x < t2.x) {
            minNode = t1; t1 = t1.next
          } else {
            minNode = t2; t2 = t2.next
          }
        }

        if (t == null) { t = minNode; r = t }
        else {
          t.next = minNode
          t = t.next
        }
      }
      r
    }
}
