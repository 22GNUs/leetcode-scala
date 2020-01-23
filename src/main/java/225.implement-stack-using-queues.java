import java.util.LinkedList;
import java.util.Queue;

class MyStack {

  private final Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack() {
    this.queue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queue.add(x);
    int size = queue.size();
    // 如果有一个以上的size则把队列颠倒过来
    for (int i = 1; i < size; i++) {
      queue.add(queue.remove());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.remove();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
