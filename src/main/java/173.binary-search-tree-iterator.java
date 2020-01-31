import java.util.Stack;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * <pre>
 * 基于中序遍历的二叉搜索数为从小到大排列
 * </pre>
 */
class BSTIterator {

  private final Stack<TreeNode> stack;
  private TreeNode root;

  public BSTIterator(TreeNode root) {
    this.root = root;
    this.stack = new Stack<>();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode curr = root;
    while (curr != null) {
      stack.push(curr);
      curr = curr.left;
    }
    curr = stack.pop();
    this.root = curr.right;
    return curr.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return root != null || !stack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
