import java.util.HashMap;
import java.util.Map;
import common.java.random.Node;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Q138 {
  public Node copyRandomList(Node head) {
    return copy(head, new HashMap<>());
  }

  private Node copy(Node head, Map<Node, Node> hash) {
    if (head == null) {
      return null;
    }
    if (hash.containsKey(head)) {
      return hash.get(head);
    }
    Node n = new Node(head.val);
    // 利用hash解决死循环
    hash.put(head, n);
    n.next = copy(head.next, hash);
    n.random = copy(head.random, hash);
    return n;
  }
}
