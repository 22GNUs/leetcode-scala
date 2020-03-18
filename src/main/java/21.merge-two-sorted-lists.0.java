import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q21V1 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode n = new ListNode(-1);
    ListNode ret = n;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        n.next = l1;
        l1 = l1.next;
      } else {
        n.next = l2;
        l2 = l2.next;
      }
      n = n.next;
    }
    if (l1 != null) {
      n.next = l1;
    }
    if (l2 != null) {
      n.next = l2;
    }
    return ret.next;
  }
}
