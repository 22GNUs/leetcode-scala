import java.util.HashMap;
class Q136 {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      // 0跟任何数亦或都为原数
      // 两个相同的数亦或也为0
      // 亦或满足交换率, 因此相同的数都两两亦或为0最后只剩不重复的数
      ans ^= nums[i];
    }
    return ans;
  }
}
