import java.util.List;
import java.util.ArrayList;

class Q119 {
  public List<Integer> getRow(int rowIndex) {
    return getRow(1, null, rowIndex + 1);
  }

  private List<Integer> getRow(int row, List<Integer> acc, int limit) {
    if (row > limit) {
      return acc;
    }
    List<Integer> curr = new ArrayList<>();
    if (acc == null || acc.isEmpty()) {
      curr.add(1);
    } else {
      List<Integer> last = acc;
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
    return getRow(row + 1, curr, limit);
  }
}
