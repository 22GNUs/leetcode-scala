/**
  * Definition for a binary tree node.
  * class common.scala.TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: common.scala.TreeNode = null
  *   var right: common.scala.TreeNode = null
  * }
  */
object Q94 {
  import common.scala.TreeNode

  /**
    * 中序遍历, 递归处理
    */
  def inorderTraversal(root: TreeNode): List[Int] =
    if (root == null) List.empty[Int]
    else inorderTraversal(root.left) ++ List(root.value) ++ inorderTraversal(root.right)
}
