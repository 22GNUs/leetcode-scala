import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } } 递归前序遍历
 */
class Q144Rec {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    traversal(root, ret);
    return ret;
  }

  private void traversal(TreeNode root, List<Integer> lst) {
    if (root == null)
      return;
    lst.add(root.val);
    traversal(root.left, lst);
    traversal(root.right, lst);
  }
}

/**
 * 前顺遍历迭代, 注意点:
 *
 * <pre>
 *  1. DFS跟BFS都是先丢一个种子节点再后续遍历
 *  2. 树结构不会重复因此不需要维护访问节点
 *  3. 根据pop顺序来决定, 因此左右push顺序要对调, 始终保持左边节点在栈顶
 * </pre>
 */
class Q144Iter {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curr = stack.pop();
      ret.add(curr.val);
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
    return ret;
  }
}
