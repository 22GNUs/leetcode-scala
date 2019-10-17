import common.scala.ListNode

/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  */
object Q19 {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    @scala.annotation.tailrec
    def toMapWithIdx(
        n: ListNode,
        i: Int,
        acc: Map[Int, ListNode]
    ): Map[Int, ListNode] =
      if (n == null) acc
      else toMapWithIdx(n.next, i + 1, acc + (i -> n))

    // 用map缓存节点的index, 只遍历一次节点
    val map = toMapWithIdx(head, 0, Map.empty[Int, ListNode])
    val idx = map.size - n
    // 头节点要特殊对待, 删除头节点的方式就是返回第二个节点-_-
    if (idx == 0) head.next
    else {
      // 其他节点的删除方式就是把前面的跟后面的接上, 跳过自己
      map(idx - 1).next = map(idx).next
      head
    }
  }
}
