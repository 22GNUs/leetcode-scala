import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 *
 * <pre>
 * 思路:
 *
 * 这题的坑在于前驱跟后继节点作为新的父节点都是对的0_0
 * 所以不需要考虑left != null && right != null的情况
 * </pre>
 */
class Q450 {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else {
      // 1. 没有子节点, 把自己删掉(return null)
      if (root.left == null && root.right == null) {
        return null;
      }
      // 2. 两个子节点都不为为null, 用中序的下一个节点代替自己, 并把下一个节点删掉
      else if (root.right != null) {
        // 节点在右边, 则可以用后继节点来代替
        TreeNode target = root.right;
        while (target.left != null) {
          target = target.left;
        }
        root.val = target.val;
        root.right = deleteNode(root.right, root.val);
      } else {
        // 节点在左边, 则可以用前驱节点来代替
        TreeNode target = root.left;
        while (target.right != null) {
          target = target.right;
        }
        root.val = target.val;
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }
}
