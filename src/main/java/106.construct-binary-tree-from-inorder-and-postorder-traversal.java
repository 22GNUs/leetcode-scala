import java.util.HashMap;
import java.util.Map;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q106 {
  private Map<Integer, Integer> memo = new HashMap<>();
  private int[] post;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    // 初始化一个map记录中序遍历的节点值跟索引的关系, 方便后续查找
    for (int i = 0; i < inorder.length; i++) {
      memo.put(inorder[i], i);
    }
    post = postorder;
    return build(0, inorder.length - 1, 0, postorder.length - 1);
  }

  /**
   * 通过节点座标递归构造节点
   * 
   * @param is 中序遍历开始座标 inOrderstart
   * @param ie 中序遍历结束座标 inOrderEnd
   * @param ps 后序遍历开始座标 postOrderStart
   * @param pe 后续遍历结束座标 postOrderEnd
   * @return 构造树
   */
  private TreeNode build(int is, int ie, int ps, int pe) {
    if (ie < is || pe < ps) {
      // 数组越界
      return null;
    }
    // 后续遍历的最后一个节点一定为根节点
    int root = post[pe];
    TreeNode node = new TreeNode(root);
    // 获取中序遍历中对应的节点索引
    int ir = memo.get(root);
    // 难点在于需要计算出新一轮的位置
    node.left = build(is, ir - 1, ps, ps + ir - 1 - is);
    node.right = build(ir + 1, ie, ps + ir - is, pe - 1);
    return node;
  }
}
