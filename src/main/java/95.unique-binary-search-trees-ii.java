import common.java.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q95 {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return build(1, n);
  }

  private List<TreeNode> build(int start, int end) {
    List<TreeNode> tree = new ArrayList<>();
    if (start > end) {
      tree.add(null);
      return tree;
    }
    for (int i = start; i <= end; i++) {
      // 分别处理左树和右树
      List<TreeNode> left = build(start, i - 1);
      List<TreeNode> right = build(i + 1, end);

      // 这段代码不是很懂
      // 每次递归调用后重新连接
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode curr = new TreeNode(i);
          curr.left = l;
          curr.right = r;
          tree.add(curr);
        }
      }
    }
    return tree;
  }
}
