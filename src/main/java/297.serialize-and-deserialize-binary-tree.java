import java.util.Arrays;
import java.util.Iterator;

import common.java.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return serialize(root, "");
  }

  /**
   * 先序遍历序列化
   * 
   * @param root 目标节点
   * @param acc  累加字符串
   * @return 结果
   */
  private String serialize(TreeNode root, String acc) {
    if (root == null) {
      return acc + "null,";
    }
    acc += (root.val + ",");
    // 注意这里的加号问题
    acc = serialize(root.left, acc);
    acc = serialize(root.right, acc);
    return acc;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    return deserialize(Arrays.asList(data.split(",")).iterator());
  }

  /**
   * 利用迭代器的特性递归
   * 
   * @param iter 迭代器
   * @return 构建好的树
   */
  private TreeNode deserialize(Iterator<String> iter) {
    if (!iter.hasNext()) {
      return null;
    }
    String next = iter.next();
    if (next.equals("null")) {
      // 终止条件
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(next));
    node.left = deserialize(iter);
    node.right = deserialize(iter);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
