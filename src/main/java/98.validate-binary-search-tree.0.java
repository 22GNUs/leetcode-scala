import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q98V1 {
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  private boolean helper(TreeNode root, Integer lo, Integer hi) {
    if (root == null) {
      return true;
    }
    int val = root.val;
    if (lo != null && val <= lo) {
      return false;
    }
    if (hi != null && val >= hi) {
      return false;
    }
    if (!helper(root.left, lo, val)) {
      return false;
    }
    if (!helper(root.right, val, hi)) {
      return false;
    }
    return true;
  }
}
