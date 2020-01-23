import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q236 {

  // 保存答案, 因为递归不能提前结束
  private TreeNode ans;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    recurse(root, p, q);
    return ans;
  }

  /**
   * 判断root是否包含p或q
   * 
   * @param root 目标节点
   * @param p    查找节点p
   * @param q    查找节点q
   * @return true or false
   */
  private boolean recurse(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      // 退出条件, 查到底了还没查到
      return false;
    }
    boolean isEqual = root == p || root == q;
    boolean isLeft = recurse(root.left, p, q);
    boolean isRight = recurse(root.right, p, q);
    if ((isEqual && isLeft) || (isEqual && isRight) || (isLeft && isRight)) {
      // 三个条件只要满足两个则表示该节点就是结果, 但是递归不能终止
      ans = root;
    }
    // 只要三个条件有一个满足则说明找到了, 应该跟递归上层反应为true
    return isEqual || isLeft || isRight;
  }
}
