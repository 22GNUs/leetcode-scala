import java.util.LinkedList;
import java.util.Queue;

class Q994 {
  public int orangesRotting(int[][] grid) {
    int ret = 0;
    int x = grid.length;
    if (x == 0) {
      return ret;
    }
    int y = grid[0].length;
    if (y == 0) {
      return ret;
    }
    // 广度优先的队列
    Queue<int[]> queue = new LinkedList<>();
    // 新鲜橘子的数量
    int count = 0;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (grid[i][j] == 2) {
          // 把腐烂的橘子入队列
          queue.add(new int[] { i, j });
        } else if (grid[i][j] == 1) {
          // 统计新鲜橘子的数量
          count++;
        }
      }
    }
    int round = 0;
    while (count > 0 && !queue.isEmpty()) {
      // 套路: 每一轮把元素都出掉, 再把新的放进去
      round++;
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        int[] orange = queue.poll();
        int r = orange[0];
        int c = orange[1];
        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
          grid[r - 1][c] = 2;
          count--;
          queue.add(new int[] { r - 1, c });
        }
        if (r + 1 < x && grid[r + 1][c] == 1) {
          grid[r + 1][c] = 2;
          count--;
          queue.add(new int[] { r + 1, c });
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
          grid[r][c - 1] = 2;
          count--;
          queue.add(new int[] { r, c - 1 });
        }
        if (c + 1 < y && grid[r][c + 1] == 1) {
          grid[r][c + 1] = 2;
          count--;
          queue.add(new int[] { r, c + 1 });
        }
      }
    }
    return count > 0 ? -1 : round;
  }
}
