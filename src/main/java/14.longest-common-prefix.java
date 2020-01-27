class Q14Java {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String ans = strs[0];
    for (int i = 1; i < strs.length; i++) {
      ans = longestCommonPrefix(ans, strs[i]);
    }
    return ans;
  }

  private static String longestCommonPrefix(String a, String b) {
    int i = 0;
    StringBuilder builder = new StringBuilder();
    while (i < a.length() && i < b.length()) {
      if (a.charAt(i) != b.charAt(i)) {
        break;
      }
      builder.append(a.charAt(i));
      i++;
    }
    return builder.toString();
  }
}
