import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路: 深度优先搜索数组, 如果不符合条件则直接break
 * 因为数组已经排序, 所以当前索引不满足时后续索引肯定也不满足, 因此下一次可以直接从后面的索引开始查找
 * 每次查找完后remove最新的索引, 继续下一个值的查询
 */
class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ret;

        Arrays.sort(candidates);
        findCombination(target, 0, candidates, new ArrayList<>(), ret);
        return ret;
    }

    /**
     * 深度优先递归搜索
     * @param target 搜索值
     * @param index 搜索深度(索引)
     * @param candidates 原始数组
     * @param curr 当前维护的数组
     * @param acc 最终结果
     */
    private void findCombination(int target, int index, int[] candidates, List<Integer> curr, List<List<Integer>> acc) {
        if (target == 0) {
            // deep copy
            acc.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            final int value = candidates[i];
            if (value > target) break;

            curr.add(value);
            findCombination(target - value, i, candidates, curr, acc);
            curr.remove(curr.size() - 1);
        }
    }
}
