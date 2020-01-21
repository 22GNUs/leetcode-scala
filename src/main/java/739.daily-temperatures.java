import java.util.Stack;

class Q739 {
  public int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<>();
    int[] ret = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      // 只要当前值大于栈顶元素, 则更新
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        ret[stack.peek()] = i - stack.pop();
      }
      // 保存当前元素到栈顶
      stack.push(i);
    }
    return ret;
  }
}
