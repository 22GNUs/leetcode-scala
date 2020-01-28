import java.util.HashSet;

class Q202 {

  public boolean isHappy(int n) {
    return isHappy(n, new HashSet<>());
  }

  private boolean isHappy(int n, HashSet<Integer> set) {
    int sum = 0;
    while (n != 0) {
      int x = n % 10;
      sum += x * x;
      n = n / 10;
    }
    // 找到 -> 跳出循环
    if (sum == 1) {
      return true;
    }
    // 重复了说明死循环 -> 跳出循环
    if (set.contains(sum)) {
      return false;
    }
    set.add(sum);
    return isHappy(sum, set);
  }
}
