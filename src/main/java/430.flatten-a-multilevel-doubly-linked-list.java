import common.java.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Q430 {
    public Node flatten(Node head) {
      Node curr = head;
      while (curr != null) {
        if (curr.child == null) {
          curr = curr.next;
          continue;
        }
        Node next = curr.next;
        Node child = curr.child;

        curr.next = child;
        child.prev = curr;
        // 注意点一
        curr.child = null;

        while (child.next != null) {
          child = child.next;
        }
        child.next = next;
        // 注意点二
        if (next != null) next.prev = child;
        curr = curr.next;
      }
      return head;
    }
}
