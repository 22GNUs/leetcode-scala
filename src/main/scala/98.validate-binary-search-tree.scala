/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  * var value: Int = _value
  * var left: TreeNode = null
  * var right: TreeNode = null
  * }
  */
object Q98 {
  import common.scala.TreeNode
  def isValidBST(root: TreeNode): Boolean = {
    def loop(root: TreeNode, low: Int, high: Int): Boolean =
      if (root == null) true
      else if (!(root.value > low && root.value < high)) false
      else loop(root.left, low, root.value) && loop(root.right, root.value, high)
    if (root == null) true
    else loop(root, root.value, root.value)
  }
}
