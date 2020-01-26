class Q28 {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    for (int i = 0; i < haystack.length(); i++) {
      // 长度不够直接返回
      if (haystack.length() - i < needle.length()) {
        return -1;
      }
      boolean find = true;
      // 首位相等, 接着往后位比较
      for (int j = 0; j < needle.length(); j++) {
        if (needle.charAt(j) != haystack.charAt(i + j)) {
          find = false;
          break;
        }
      }
      if (find) {
        return i;
      }
      continue;
    }
    return -1;
  }
}
