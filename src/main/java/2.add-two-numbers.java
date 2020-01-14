import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q2Java {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode ret = head;
    boolean carry = false;
    while (l1 != null || l2 != null) {
      int val1 = l1 == null ? 0 : l1.val;
      int val2 = l2 == null ? 0 : l2.val;
      int sum = val1 + val2;
      if (carry) {
        sum += 1;
        // 先重置
        carry = false;
      }
      if (sum >= 10) {
        sum = sum % 10;
        // 又有进位则再进位
        carry = true;
      }
      head = addNode(head, sum);
      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
    }
    // 循环出来之后carry还存在, 需要再进一位
    if (carry) {
      head = addNode(head, 1);
    }
    return ret.next;
  }

  private ListNode addNode(ListNode target, int number) {
    ListNode newNode = new ListNode(number);
    target.next = newNode;
    return newNode;
  }
}
