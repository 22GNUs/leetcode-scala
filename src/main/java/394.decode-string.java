import java.util.Stack;

/**
 * @see https://www.youtube.com/watch?v=fFAR688RLko
 */
class Q394 {
  public String decodeString(String s) {
    int num = 0;
    // 栈, 内部可能保存Integer和String
    Stack<Object> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c >= '0' && c <= '9') {
        // 数字
        // 这样处理是因为数字可能有多位
        num = num * 10 + c - '0';
      } else if (c == '[') {
        // 入口, 次数入队
        stack.push(num);
        num = 0;
      } else if (c == ']') {
        // 出口, 按顺序重新组合后再入栈
        String res = toString(stack);
        int count = (Integer) stack.pop();
        for (int i = 0; i < count; i++) {
          stack.push(res);
        }
      } else {
        // 字母
        stack.push(String.valueOf(c));
      }
    }
    // 在这里的是否stack里面已经全部是string了
    return toString(stack);
  }

  private String toString(Stack<Object> stack) {
    String res = "";
    while (!stack.isEmpty() && stack.peek() instanceof String) {
      res = ((String) stack.pop()) + res;
    }
    return res;
  }
}
