import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> lst = new ArrayList<>();
      // 利用队列长度属性控制层次
      // 注意for循环内部的size也是实时调用方法的
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.remove();
        lst.add(curr.val);
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      ret.add(lst);
    }
    return ret;
  }
}
