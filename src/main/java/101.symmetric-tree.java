import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 思路:
 * 
 * <pre>
 * 主要是需要直到判断逻辑是什么
 * 左树val == 右树val && 左树往左遍历 == 右树往右遍历 && 左树往右遍历 == 右树往左遍历
 * </pre>
 */
class Q101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    }
    if (l == null || r == null) {
      return false;
    }
    return (l.val == r.val) && isMirror(l.left, r.right) && isMirror(l.right, r.left);
  }
}
