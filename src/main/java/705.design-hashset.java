class MyHashSet {

  private final int[] array;

  /** Initialize your data structure here. */
  public MyHashSet() {
    this.array = new int[1000000];
    for (int i = 0; i < array.length; i++) {
      array[i] = -1;
    }
  }

  public void add(int key) {
    array[hash(key)] = key;
  }

  public void remove(int key) {
    array[hash(key)] = -1;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int idx = hash(key);
    return array[idx] != -1;
  }

  private int hash(int key) {
    return key % this.array.length;
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
