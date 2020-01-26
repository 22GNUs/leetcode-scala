import java.util.List;
import java.util.ArrayList;

class Q54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int rows = matrix.length;
    List<Integer> ret = new ArrayList<>();
    if (rows == 0) {
      return ret;
    }
    int cols = matrix[0].length;
    // 设置边界值
    int up = 0;
    int down = rows - 1;
    int left = 0;
    int right = cols - 1;
    // 每次循环后重新设置边界
    while (true) {
      // 先往右遍历
      for (int i = left; i <= right; i++) {
        ret.add(matrix[up][i]);
      }
      if (++up > down) {
        break;
      }
      // 往下遍历
      for (int i = up; i <= down; i++) {
        ret.add(matrix[i][right]);
      }
      if (--right < left) {
        break;
      }
      // 往左遍历
      for (int i = right; i >= left; i--) {
        ret.add(matrix[down][i]);
      }
      if (--down < up) {
        break;
      }
      for (int i = down; i >= up; i--) {
        ret.add(matrix[i][left]);
      }
      if (++left > right) {
        break;
      }
    }
    return ret;
  }
}
