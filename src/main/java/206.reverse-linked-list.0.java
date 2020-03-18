import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Q206V1 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode hd = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = hd;
      hd = head;
      head = next;
    }
    return hd;
  }
}
