/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object Q110 {
  import java.lang.Math
  import common.scala.TreeNode

  def isBalanced(root: TreeNode): Boolean =
    if (root == null) true
    else {
      def maxDepth(root: TreeNode): Int =
        if (root == null) 0
        else {
          val left  = maxDepth(root.left)
          val right = maxDepth(root.right)
          return Math.max(left, right) + 1
        }
      val balance = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
      balance && isBalanced(root.left) && isBalanced(root.right)
    }

}
