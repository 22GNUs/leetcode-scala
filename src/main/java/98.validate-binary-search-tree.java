import java.util.Stack;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 *
 * <pre>
 * 思路:
 * 依赖迭代中序遍历, 并且中序遍历的结果为从小到大排列
 * 比较当前节点跟上一个节点的大小
 * </pre>
 */
class Q98 {
  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    TreeNode prev = null;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      TreeNode top = stack.pop();
      if (prev != null && top.val <= prev.val) {
        return false;
      }
      prev = top;
      curr = top.right;
    }
    return true;
  }
}
