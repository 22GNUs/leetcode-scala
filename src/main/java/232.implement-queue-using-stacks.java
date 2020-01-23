import java.util.Stack;

class MyQueue {

  private final Stack<Integer> s1;
  private final Stack<Integer> s2;

  /** Initialize your data structure here. */
  public MyQueue() {
    this.s1 = new Stack<>();
    this.s2 = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    this.s1.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    shift();
    if (s2.isEmpty()) {
      throw new IllegalStateException("没有元素");
    }
    return s2.pop();
  }

  /** Get the front element. */
  public int peek() {
    shift();
    if (s2.isEmpty()) {
      throw new IllegalStateException("没有元素");
    }
    return s2.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

  private void shift() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
