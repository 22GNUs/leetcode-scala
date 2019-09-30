import common.ListNode

/**
  * 以后这种题还是拿Java写算了...
  * 链表节点不是case class还是null实在是有点坑
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  *   var next: ListNode = null
  *   var x: Int = _x
  * }
  */
object Q23 {
  def mergeKLists(lists: Array[ListNode]): ListNode =
    if (lists == null || lists.isEmpty) null
    else {
      // 思路: 每次遍历一轮选出最小值, 将最小值添加到结果链表
      // 同时把对应的数组中的链表节点设置为next
      // 当选出来的最小值为null时, 说明所有节点都遍历结束了
      @scala.annotation.tailrec
      def loop(curr: ListNode, ret: ListNode): ListNode = {
        // 先找到数组中最小的值
        val min = lists.zipWithIndex.reduceLeft[(ListNode, Int)] {
          case (acc @ (n1, _), item @ (n2, _)) =>
            if (n1 == null) item
            else if (n2 == null) acc
            else if (n1.x < n2.x) acc
            else item
        }
        min match {
          case (null, _) => ret
          // 没找到说明数组已经遍历完了
          case (n, idx) =>
            lists(idx) = n.next
            val node = new ListNode(n.x)
            if (curr == null) {
              loop(node, node)
            } else {
              curr.next = node
              loop(node, ret)
            }
        }
      }
      loop(null, null)
    }
}
