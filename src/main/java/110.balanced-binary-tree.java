import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q110Java {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int left = height(root.left);
    int right = height(root.right);
    return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }
}
