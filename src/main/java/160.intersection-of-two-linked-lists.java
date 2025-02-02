import common.java.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode a = headA, b = headB;
      while (a != b) {
        a = a == null ? headB : a.next;
        b = b == null ? headA : b.next;
      }
      return a;
    }
}
