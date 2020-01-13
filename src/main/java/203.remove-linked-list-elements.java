import common.java.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        ListNode prev = start;
        prev.next = head;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val == val) {
                prev.next = next;
                curr.next = null;
            } else {
                prev = curr;
            }
            curr = next;
        }
        return start.next;
    }
}
