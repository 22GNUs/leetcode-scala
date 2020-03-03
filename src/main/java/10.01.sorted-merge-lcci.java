/**
 * 思路: 双指针从后到前插入
 */
class SortedMergeLcci {
  public void merge(int[] A, int m, int[] B, int n) {
    int curA = m - 1;
    int curB = n - 1;
    int tail = m + n - 1;
    while (curA >= 0 || curB >= 0) {
      if (curA == -1) {
        A[tail] = B[curB--];
      } else if (curB == -1) {
        A[tail] = A[curA--];
      } else if (A[curA] > B[curB]) {
        A[tail] = A[curA--];
      } else {
        A[tail] = B[curB--];
      }
      tail -= 1;
    }
  }
}
