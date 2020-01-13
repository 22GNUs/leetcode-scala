class Q707 {

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int length;

    /**
     * Initialize your data structure here.
     */
    public Q707() {
        this.head = new Node(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= this.length) return -1;
        Node n = head;
        // 加上等于, 相当于多循环一次, 把默认的head跳过
        for (int i = 0; i <= index; i++) {
            n = n.next;
        }
        return n.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node n = new Node(val);
        Node origin = head.next;
        head.next = n;
        n.next = origin;
        this.length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node n = new Node(val);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
        this.length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.length) {
            addAtTail(val);
            return;
        }
        if (index > this.length) return;
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        Node append = new Node(val);
        Node next = n.next;
        n.next = append;
        append.next = next;
        this.length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (length == 0 || index >= length) return;
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        n.next = n.next.next;
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */