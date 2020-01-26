class Q498 {
  public int[] findDiagonalOrder(int[][] matrix) {
    int rows = matrix.length;
    if (matrix.length == 0) {
      return new int[0];
    }
    int cols = matrix[0].length;
    int[] ret = new int[rows * cols];
    int idx = 0;
    for (int i = 0; i < Math.max(rows, cols) * 2; i++) {
      if (i % 2 == 0) {
        // 从下往上遍历, (i, 0)
        int row = i;
        int col = 0;
        while (row >= 0 && col < cols) {
          if (row < rows && col >= 0) {
            ret[idx++] = matrix[row][col];
          }
          row--;
          col++;
        }
      } else {
        int row = 0;
        int col = i;
        while (row < rows && col >= 0) {
          if (row >= 0 && col < cols) {
            ret[idx++] = matrix[row][col];
          }
          row++;
          col--;
        }
      }
    }
    return ret;
  }
}
