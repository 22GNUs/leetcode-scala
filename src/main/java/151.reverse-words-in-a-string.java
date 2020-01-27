/**
 * 151正经做法
 */
class Q151 {
  public String reverseWords(String s) {
    StringBuilder ret = new StringBuilder();
    String tmp = "";
    s += " ";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ' && !tmp.isEmpty()) {
        // 后面的加到前面
        if (ret.length() == 0) {
          ret.insert(0, tmp);
        } else {
          ret.insert(0, tmp + ' ');
        }
        tmp = "";
      } else if (s.charAt(i) != ' ') {
        tmp += s.charAt(i);
      }
    }
    return ret.toString();
  }
}
