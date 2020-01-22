import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Stack<TreeNode> stack = new Stack<>();
    // 不同点是不需要先入栈根节点
    TreeNode curr = root;
    while (!stack.isEmpty() || curr != null) {
      // 大循环里面再按先遍历左树
      // 只要有左树就把左树优先入栈
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // 处理左树后处理右树, 如果右树为null则再出栈继续下一层
      TreeNode top = stack.pop();
      ret.add(top.val);
      curr = top.right;
    }
    return ret;
  }
}
