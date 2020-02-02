class KthLargest {

  private TreeNode root;
  private final int k;

  private final static class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    private int cnt;

    private TreeNode(int val) {
      this.val = val;
      this.cnt = 1;
    }
  }

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int i = 0; i < nums.length; i++) {
      this.root = insert(root, nums[i]);
    }
  }

  public int add(int val) {
    this.root = insert(root, val);
    TreeNode node = search(root, k);
    return node == null ? -1 : node.val;
  }

  private TreeNode search(TreeNode root, int n) {
    if (root == null) {
      return null;
    }
    int leftCnt = root.left == null ? 0 : root.left.cnt;
    int rightCnt = root.right == null ? 0 : root.right.cnt;
    int rootCnt = root.cnt - leftCnt - rightCnt;
    // 如果数量比右子树小, 则在右子树找
    if (n <= rightCnt) {
      return search(root.right, n);
    } else if (n > rootCnt + rightCnt) {
      // 如果数量比右子树加root数量大, 则在左子树找
      return search(root.left, n - rightCnt - rootCnt);
    }
    return root;
  }

  private TreeNode insert(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val > root.val) {
      root.right = insert(root.right, val);
    } else if (val < root.val) {
      root.left = insert(root.left, val);
    }
    // 重复节点算多次
    root.cnt++;
    return root;
  }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
