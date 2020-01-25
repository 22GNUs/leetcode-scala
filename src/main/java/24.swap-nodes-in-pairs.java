import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q24Java {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode node = head.next;
    head.next = swapPairs(node.next);
    node.next = head;
    return node;
  }
}
