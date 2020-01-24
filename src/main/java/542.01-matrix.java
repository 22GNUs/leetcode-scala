import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路:
 * <pre>类似岛屿数量, 通过BFS更新节点<pre>
 */
class Q542 {
  public int[][] updateMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // 标记所有0的位置
        // 编码后入队列
        if (matrix[i][j] == 0) {
          queue.add(i * cols + j);
        } else {
          // 1全部标记为最大值, 在BFS中把最大值节点全部更新
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }
    // 以所有0坐标开始搜索
    while (!queue.isEmpty()) {
      int point = queue.remove();
      int x = point / cols;
      int y = point % cols;
      int value = matrix[x][y];

      // 上
      if (y + 1 < cols && matrix[x][y + 1] > value) {
        matrix[x][y + 1] = matrix[x][y] + 1;
        queue.add(x * cols + y + 1);
      }
      // 下
      if (y - 1 >= 0 && matrix[x][y - 1] > value) {
        matrix[x][y - 1] = matrix[x][y] + 1;
        queue.add(x * cols + y - 1);
      }
      // 左
      if (x + 1 < rows && matrix[x + 1][y] > value) {
        matrix[x + 1][y] = matrix[x][y] + 1;
        queue.add((x + 1) * cols + y);
      }
      // 右
      if (x - 1 >= 0 && matrix[x - 1][y] > value) {
        matrix[x - 1][y] = matrix[x][y] + 1;
        queue.add((x - 1) * cols + y);
      }
    }
    return matrix;
  }
}
