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
      Character c = s.charAt(i);
      if (!map.containsKey(c)) {
        stack.push(c);
        continue;
      }
      // 反括号栈内没有值或者前一个匹配不上
      if (stack.isEmpty() || map.get(c) != stack.pop()) {
        return false;
      }
    }
    // 如果还有没用完的开始括号则不对
    return stack.isEmpty();
  }
}
