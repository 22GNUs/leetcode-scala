import java.util.HashMap;
import java.util.Map;

/**
 * 两数只和二刷
 */
class Q1V1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int other = target - nums[i];
      if (map.get(other) != null) {
        return new int[]{map.get(other), i};
      }
      map.put(nums[i], i);
    }
    return new int[]{};
  }
}
