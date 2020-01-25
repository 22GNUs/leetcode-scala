import java.util.ArrayList;
import java.util.List;

/**
 * 话说我这尾递归不就是循环吗-_-
 */
class Q118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> lst = new ArrayList<>();
    generate(1, lst, numRows);
    return lst;
  }

  private void generate(int row, List<List<Integer>> lst, int limit) {
    if (row > limit) {
      return;
    }
    List<Integer> curr = new ArrayList<>();
    if (lst.isEmpty()) {
      curr.add(1);
    } else {
      List<Integer> last = lst.get(lst.size() - 1);
      int lastSize = last.size();
      for (int i = 0; i < row; i++) {
        if (i == 0 || i >= lastSize) {
          // 最后一个
          curr.add(1);
          continue;
        }
        curr.add(last.get(i - 1) + last.get(i));
      }
    }
    lst.add(curr);
    generate(row + 1, lst, limit);
  }
}
