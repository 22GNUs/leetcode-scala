class Q66 {
  public int[] plusOne(int[] digits) {
    int i = digits.length - 1;
    while (i >= 0) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
        return digits;
      }
      i--;
    }
    // 处理越界问题
    int[] ret = new int[digits.length + 1];
    ret[0] = 1;
    return ret;
  }
}
