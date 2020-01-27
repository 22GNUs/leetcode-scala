class Q733 {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    fill(image, sr, sc, image[sr][sc], newColor);
    return image;
  }

  private void fill(int[][] image, int sr, int sc, int targetColor, int newColor) {
    int rows = image.length;
    int cols = image[0].length;
    if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) {
      return;
    }
    int color = image[sr][sc];
    if (color != targetColor) {
      return;
    }
    // 这个条件很重要, 避免死循环
    // 可能的死循环是隔壁的跟自己都是一个颜色不需要修改, 导致前面两个return都不执行
    // 在两个格子之间循环跳
    if (color == newColor) {
      return;
    }
    image[sr][sc] = newColor;
    fill(image, sr - 1, sc, targetColor, newColor);
    fill(image, sr + 1, sc, targetColor, newColor);
    fill(image, sr, sc - 1, targetColor, newColor);
    fill(image, sr, sc + 1, targetColor, newColor);
  }
}
