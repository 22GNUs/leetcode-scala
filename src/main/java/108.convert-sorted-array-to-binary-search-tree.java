import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Q108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length);
  }

  private TreeNode build(int[] nums, int start, int end) {
    if (start >= end) {
      return null;
    }
    int mid = (start + end) >> 1;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = build(nums, start, mid);
    node.right = build(nums, mid + 1, end);
    return node;
  }
}
