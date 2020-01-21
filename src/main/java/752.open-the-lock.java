import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先搜索解法 思路:
 *
 * <pre>
 * 每一种状态可以有8种可能的变化, 这8种变化算作1轮,
 * 利用广度优化搜索在某一轮(重点, 每一层找到之后就要直接返回)搜索中找到了目标值则为结果
 * 如果找到了死亡数字, 则直接返回, 因为题目条件为锁死了无法继续任何操作
 * </pre>
 */
class Q752BFS {
  public int openLock(String[] deadends, String target) {
    Set<String> visted = new HashSet<>();
    Collections.addAll(visted, deadends);

    if (visted.contains("0000")) {
      return -1;
    }
    Queue<String> queue = new LinkedList<>();
    queue.add("0000");
    visted.add("0000");
    int ret = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      // 每一层找完就删掉, 保证每次进来都是新的一层
      for (int i = 0; i < size; i++) {
        String curr = queue.remove();
        if (curr.equals(target)) {
          return ret;
        }
        char[] chars = curr.toCharArray();
        for (int j = 0; j < 4; j++) {
          char tmp = chars[j];
          for (int k = -1; k < 2; k += 2) {
            // 类型转换
            // see:
            // https://stackoverflow.com/questions/17984975/convert-int-to-char-in-java/33031728
            // %10 处理(9 + 1)的边界
            // (k + 10) % 10 处理 -1 和 9的边界
            chars[j] = (char) (((tmp - '0' + k + 10) % 10) + '0');
            String next = String.valueOf(chars);
            if (visted.add(next)) {
              queue.add(next);
            }
          }
          // 改回去
          chars[j] = tmp;
        }
      }
      ret++;
    }
    return -1;
  }
}
