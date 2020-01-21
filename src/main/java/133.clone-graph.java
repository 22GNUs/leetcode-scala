import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.java.graph.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
* 思路还是保存hash, 访问过的直接返回(就是退出条件)
*/
class Q133 {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    return dfsClone(node, new HashMap<>());
  }

  private Node dfsClone(Node node, Map<Integer, Node> visted) {
    assert node != null;
    Node ret = new Node(node.val);
    List<Node> neighbors = new ArrayList<>();
    ret.neighbors = neighbors;
    visted.put(node.val, ret);
    if (node.neighbors != null) {
      for (Node n : node.neighbors) {
        neighbors.add(visted.containsKey(n.val) ? visted.get(n.val) : dfsClone(n, visted));
      }
    }
    return ret;
  }
}
