import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q15Java {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) return ret;
        final int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++) {
            // 因为是从小到大排序, 如果首位已经大于0了, 和不可能==0
            // nums(i) == nums(i - 1) 表示这轮的值跟上一轮是一样的, 没必要接着找了, 继续下一轮
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                final int ans = nums[i] + nums[l] + nums[r];
                if (ans == 0) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 调整l和r的值, 继续在本轮找
                    l++;
                    r--;
                    // 值太大了, 把右边左移, 调小
                } else if (ans > 0) r--;
                else l++;
            }
        }
        return ret;
    }
}
