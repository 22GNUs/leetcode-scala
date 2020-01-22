import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ret = new LinkedList<>();
    if (root == null) {
      return ret;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      // 后续遍历就是反向的前序遍历(右子树优先)再取反(左子树优先), 往list的前面插入
      // 不止保存结果要取反
      // 遍历顺序也要取反
      ret.addFirst(curr.val);
      if (curr.left != null) {
        stack.push(curr.left);
      }
      if (curr.right != null) {
        stack.push(curr.right);
      }
    }
    return ret;
  }
}
