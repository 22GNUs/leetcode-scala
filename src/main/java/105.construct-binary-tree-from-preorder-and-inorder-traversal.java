import java.util.HashMap;
import java.util.Map;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 索引位置把握太难了!
 */
class Q105 {
  private int[] pre;
  private Map<Integer, Integer> memo = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      memo.put(inorder[i], i);
    }
    this.pre = preorder;
    return build(0, preorder.length, 0, inorder.length);
  }

  private TreeNode build(int ps, int pe, int is, int ie) {
    if (ps == pe || ie < is) {
      return null;
    }
    int value = pre[ps];
    TreeNode root = new TreeNode(value);

    // 中序遍历的位置
    int ri = memo.get(value);
    root.left = build(ps + 1, ps + (ri - is) + 1, is, ri);
    root.right = build(ps + (ri - is) + 1, pe, ri + 1, ie);
    return root;
  }
}
