import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Q206V2 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    return reverse(head, null);
  }

  private ListNode reverse(ListNode h, ListNode acc) {
    if (h == null) {
      return acc;
    }
    ListNode n = h.next;
    h.next = acc;
    return reverse(n, h);
  }
}
