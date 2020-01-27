class Q557 {
  public String reverseWords(String s) {
    int size = s.length();
    StringBuilder builder = new StringBuilder();
    String tmp = "";
    for (int i = 0; i <= size; i++) {
      // 利用或短路特性
      if (i != size && s.charAt(i) != ' ') {
        tmp += s.charAt(i);
        continue;
      }
      builder.append(reverseWord(tmp));
      if (i != size) {
        // 左后一位不加空格
        builder.append(" ");
      }
      tmp = "";
    }
    return builder.toString();
  }

  private String reverseWord(String w) {
    if (w.length() < 2) {
      return w;
    }
    char[] cs = w.toCharArray();
    int i = 0;
    int j = cs.length - 1;
    while (i < j) {
      char tmp = cs[i];
      cs[i] = cs[j];
      cs[j] = tmp;
      i++;
      j--;
    }
    return String.valueOf(cs);
  }
}
