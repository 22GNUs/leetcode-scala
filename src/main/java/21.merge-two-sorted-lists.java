import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q21Java {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    ListNode head = new ListNode(-1);
    ListNode ret = head;
    ListNode i = l1, j = l2;
    while (i != null && j != null) {
      if (i.val < j.val) {
        head.next = i;
        i = i.next;
      } else {
        head.next = j;
        j = j.next;
      }
      head = head.next;
    }
    if (i != null)
      head.next = i;
    if (j != null)
      head.next = j;
    return ret.next;
  }
}
