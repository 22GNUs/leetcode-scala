import java.util.HashMap;
import java.util.Map;

class Q1Java {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int other = target - nums[i];
      if (map.containsKey(other)) {
        return new int[] { map.get(other), i };
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
