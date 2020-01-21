import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    if (s.isEmpty()) {
      return true;
    }
    Map<Character, Character> map = new HashMap<>(3);
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c)) {
        // 正括号, 入栈
        stack.push(c);
        continue;
      }
      // 反括号并且栈内没有值 || 前一个括号不匹配
      if (stack.isEmpty() || map.get(c) != stack.pop()) {
        return false;
      }
    }
    // 最后还有没有匹配光的值则不合法
    return stack.isEmpty();
  }
}
