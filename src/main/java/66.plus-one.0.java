class Q66V1 {
  public int[] plusOne(int[] digits) {
    int i = digits.length - 1;
    while (i >= 0) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
        // 没有进位则直接返回
        return digits;
      }
      i--;
    }
    // 首位还为0, 进一位
    int[] ret = new int[digits.length + 1];
    ret[0] = 1;
    return ret;
  }
}
