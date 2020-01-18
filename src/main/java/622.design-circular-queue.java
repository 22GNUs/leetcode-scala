class MyCircularQueue {

  private final int[] array;
  private final int capicity;
  private int head = 0, tail = 0;

  /** Initialize your data structure here. Set the size of the queue to be k. */
  public MyCircularQueue(int k) {
    capicity = k + 1;
    this.array = new int[capicity];
  }

  /**
   * Insert an element into the circular queue. Return true if the operation is
   * successful.
   */
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    array[tail] = value;
    tail = (tail + 1) % capicity;
    return true;
  }

  /**
   * Delete an element from the circular queue. Return true if the operation is
   * successful.
   */
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    head = (head + 1) % capicity;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return array[head];
  }

  /** Get the last item from the queue. */
  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    // 防止tail为0的情况
    return array[(tail - 1 + capicity) % capicity];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return head == tail;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return (tail + 1) % capicity == head;
  }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
