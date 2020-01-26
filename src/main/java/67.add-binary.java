class Q67 {
  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    // 进位标记
    int mark = 0;
    String ret = "";
    while (i >= 0 || j >= 0) {
      int that;
      if (i >= 0 && j >= 0) {
        that = (a.charAt(i) - '0') + (b.charAt(j) - '0') + mark;
      } else if (i >= 0) {
        that = a.charAt(i) - '0' + mark;
      } else {
        that = b.charAt(j) - '0' + mark;
      }
      mark = that / 2;
      ret = ((char) (that % 2 + '0')) + ret;
      i--;
      j--;
    }
    if (mark == 1) {
      return "1" + ret;
    }
    return ret;
  }
}
