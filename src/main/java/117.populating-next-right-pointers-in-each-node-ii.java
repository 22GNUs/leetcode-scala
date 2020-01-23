import java.util.LinkedList;
import java.util.Queue;

import common.java.q116.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
没看懂递归操作-_-, 虽然不符合题意但是层序遍历能解决问题..
*/
class Q117 {
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node last = null;
      for (int i = 0; i < size; i++) {
        Node node = queue.remove();
        if (last != null) {
          last.next = node;
        }
        last = node;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return root;
  }

}
