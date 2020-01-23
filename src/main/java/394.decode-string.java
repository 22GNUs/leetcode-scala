import java.util.Stack;

class Solution {
  public String decodeString(String s) {
    if (s == null) {
      return null;
    }
    String ret = "";
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ']') {
        String tmp = "";
        c = stack.pop();
        while (c != '[') {
          // 栈中方向是反的
          tmp = c + tmp;
          c = stack.pop();
        }
        int number = stack.pop() - '0';
        while (number > 0) {
          ret += tmp;
          number--;
        }
        continue;
      }
      stack.push(c);
    }
    return ret;
  }
}
