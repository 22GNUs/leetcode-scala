import common.java.ListNode;
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q328 {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode oddH = head, odd = head, evenH = head.next, even = head.next;
    while (even != null && even.next != null) {
      odd.next = even.next;
      even.next = odd.next.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenH;
    return oddH;
  }
}
