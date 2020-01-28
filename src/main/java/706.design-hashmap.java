class MyHashMap {

  private static class Node {
    private int key;
    private int val;
    private Node next;

    private Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private Node[] bucket;

  /** Initialize your data structure here. */
  public MyHashMap() {
    this.bucket = new Node[100000];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int idx = hash(key);
    Node ext = bucket[idx];
    Node curr = ext;
    while (curr != null) {
      if (curr.key == key) {
        curr.val = value;
        return;
      }
      curr = curr.next;
    }
    Node node = new Node(key, value);
    bucket[idx] = node;
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map
   * contains no mapping for the key
   */
  public int get(int key) {
    int idx = hash(key);
    Node ext = bucket[idx];
    while (ext != null) {
      if (ext.key == key) {
        return ext.val;
      }
    }
    return -1;
  }

  /**
   * Removes the mapping of the specified value key if this map contains a mapping
   * for the key
   */
  public void remove(int key) {
    int idx = hash(key);
    Node ext = bucket[idx];
    if (ext == null) {
      return;
    }
    Node prev = null;
    while (ext != null) {
      if (ext.key == key) {
        if (prev == null) {
          bucket[idx] = ext.next;
        } else {
          prev.next = ext.next;
        }
        return;
      }
      ext = ext.next;
      prev = ext;
    }
  }

  private int hash(int key) {
    return key % bucket.length;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
