import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Q841BFS {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    if (rooms.size() == 0) {
      return false;
    }
    Set<Integer> visted = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    // 0号房间默认是打开的
    queue.add(0);
    visted.add(0);
    while (!queue.isEmpty()) {
      Integer key = queue.remove();
      for (Integer k : rooms.get(key)) {
        if (!visted.contains(k)) {
          queue.add(k);
        }
        visted.add(k);
      }
    }
    return visted.size() == rooms.size();
  }
}

class Q841DFS {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visted = new HashSet<>();
    dfs(rooms, 0, visted);
    return visted.size() == rooms.size();
  }

  private void dfs(List<List<Integer>> rooms, int idx, Set<Integer> visted) {
    if (visted.contains(idx)) {
      return;
    }
    visted.add(idx);
    for (Integer key : rooms.get(idx)) {
      dfs(rooms, key, visted);
    }
  }
}
