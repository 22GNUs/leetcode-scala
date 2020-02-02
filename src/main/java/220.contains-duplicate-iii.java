import java.util.TreeSet;

class Q220 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Integer> tree = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      // 找到nums[i]的后继节点
      Integer c = tree.ceiling(nums[i]);
      if (c != null && c <= nums[i] + t) {
        return true;
      }

      // 找到nums[i]的前驱节点
      Integer f = tree.floor(nums[i]);
      if (f != null && nums[i] <= f + t) {
        return true;
      }
      
      tree.add(nums[i]);
      if (tree.size() > k) {
        // 核心代码, 通过树来维护k个窗口
        tree.remove(nums[i - k]);
      }
    }
    return false;
  }
}
