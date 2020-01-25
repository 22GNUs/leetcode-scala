class Q344 {
  public void reverseString(char[] s) {
    if (s.length == 0) {
      return;
    }
    reverse(s, 0, s.length - 1);
  }

  private void reverse(char[] s, int start, int end) {
    if (start >= end) {
      return;
    }
    char tmp = s[start];
    s[start] = s[end];
    s[end] = tmp;
    reverse(s, start + 1, end - 1);
  }
}
