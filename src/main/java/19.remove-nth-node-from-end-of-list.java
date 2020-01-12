import common.java.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 思路:
 * <pre>
 * 双指针, 先拉开n个距离, 再利用这个距离求解
 * 难点在于要处理只有单个节点的链表这样的情况, 所以要额外引入一个头
 * </pre>
 */
class Q19Java {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode hd = new ListNode(0);
      hd.next = head;
      ListNode fast = hd;
      // 这里的+1其实就是把hd包括进去
      for (int i = 0; i < n + 1; i++) {
        fast = fast.next;
      }
      ListNode slow = hd;
      while (fast != null) {
        fast = fast.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;
      return hd.next;
    }
}
