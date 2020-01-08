import common.java.ListNode;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 * 思路:
 * <pre>
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 * 关键字: k=a+nb
 * </pre>
 */
public class Q142 {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head, fast = head;
    ListNode meet = null;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        meet = slow;
        break;
      }
    }
    if (meet == null)
      return null;
    fast = head;
    while (meet != fast) {
      meet = meet.next;
      fast = fast.next;
    }
    return meet;
  }
}
