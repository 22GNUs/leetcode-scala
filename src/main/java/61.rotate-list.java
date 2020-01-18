import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    if (k == 0) {
      return head;
    }
    ListNode tail = head;
    int len = 1;
    while (tail.next != null) {
      tail = tail.next;
      len++;
    }
    if (len == 1) {
      return head;
    }
    int n = len - (k % len);
    // 断开点为尾巴则直接返回, 边界条件
    if (n == len)
      return head;
    System.out.println(n);
    if (n == 0)
      return head;
    ListNode breakNode = head;
    for (int i = 0; i < n - 1; i++) {
      breakNode = breakNode.next;
    }
    ListNode ret = breakNode.next;
    breakNode.next = null;
    tail.next = head;
    return ret;
  }
}
