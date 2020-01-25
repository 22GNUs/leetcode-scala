class Q50 {
  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    // 二分法优化时间复杂度
    double half = myPow(x, n / 2);
    double left = myPow(x, n % 2);
    return half * half * left;
  }
}
