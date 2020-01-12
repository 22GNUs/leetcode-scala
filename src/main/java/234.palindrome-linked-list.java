import common.java.ListNode;
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 重点:
 * <pre>
 *  1. prev保存的是当前的slow的前一个节点
 *  2. while退出的条件是fast != null && fast.next != null
 *  也就是说退出有可能是以上两种情况
 *  如果是第二种情况退出, 则把slow指针往后挪一位(链表长度为奇数), 排除中间节点
 * </pre>
 */
class Q234 {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    ListNode slow = head, fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    if (fast != null) {
      slow = slow.next;
    }
    while (prev != null && slow != null) {
      if (prev.val != slow.val) {
        return false;
      }
      prev = prev.next;
      slow = slow.next;
    }
    return true;
  }
}
