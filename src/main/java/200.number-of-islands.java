import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索解法 思路:
 * 
 * <pre>
 * 首先找到岛屿节点(1), 找到后把附近所有岛屿都通过BFS置为已访问
 * 这样每次找到的1就是一片新的岛屿
 * </pre>
 */
class Q200BFS {
  public int numIslands(char[][] grid) {
    int rows = grid.length;
    if (rows == 0) {
      return 0;
    }
    int cols = grid[0].length;
    int ret = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          ret++;
          // 标记为已访问
          grid[i][j] = '0';
          // 开始广度优先搜索
          Queue<Integer> queue = new LinkedList<>();
          // 对坐标编码, 方便保存
          queue.add(i * cols + j);

          // 开始搜索
          while (!queue.isEmpty()) {
            int curr = queue.remove();
            int x = curr / cols;
            int y = curr % cols;

            // 分别处理上下左右四个位置
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
              grid[x][y - 1] = '0';
              queue.add(x * cols + y - 1);
            }
            if (y + 1 < cols && grid[x][y + 1] == '1') {
              grid[x][y + 1] = '0';
              queue.add(x * cols + y + 1);
            }
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
              grid[x - 1][y] = '0';
              queue.add((x - 1) * cols + y);
            }
            if (x + 1 < rows && grid[x + 1][y] == '1') {
              grid[x + 1][y] = '0';
              queue.add((x + 1) * cols + y);
            }
          }
        }
      }
    }
    return ret;
  }
}

/**
 * 深度优先搜索, 利用递归栈
 */
class Q200DFS {
  public int numIslands(char[][] grid) {
    int rows = grid.length;
    if (rows == 0) {
      return 0;
    }
    int cols = grid[0].length;
    int ret = 0;
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        if (grid[x][y] == '1') {
          ret++;
          dfs(grid, x, y);
        }
      }
    }
    return ret;
  }

  private void dfs(char[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x - 1, y);
    dfs(grid, x + 1, y);
    dfs(grid, x, y - 1);
    dfs(grid, x, y + 1);
  }
}
