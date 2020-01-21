/**
 * 通过在node上维护一个最小值来保存
 */
class MinStack {
  class Node {
    int value;
    int min;
    Node next;

    Node(int x, int min) {
      this.value = x;
      this.min = min;
      next = null;
    }
  }

  Node head;

  // 每次加入的节点放到头部
  public void push(int x) {
    if (null == head) {
      head = new Node(x, x);
    } else {
      // 当前值和之前头结点的最小值较小的做为当前的 min
      Node n = new Node(x, Math.min(x, head.min));
      n.next = head;
      head = n;
    }
  }

  public void pop() {
    if (head != null)
      head = head.next;
  }

  public int top() {
    if (head != null)
      return head.value;
    return -1;
  }

  public int getMin() {
    if (null != head)
      return head.min;
    return -1;
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
