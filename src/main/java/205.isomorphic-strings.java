import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Q205V1 {
  public boolean isIsomorphic(String s, String t) {
    int length = s.length();
    if (length == 0) {
      return true;
    }
    Map<Character, String> m1 = new HashMap<>(length);
    Map<Character, String> m2 = new HashMap<>(length);
    for (int i = 0; i < length; i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      String v1 = m1.get(c1) == null ? String.valueOf(i) : m1.get(c1) + i;
      String v2 = m2.get(c2) == null ? String.valueOf(i) : m2.get(c2) + i;
      // 依据每个字符的出现次数来判断, 如果出现次数不等则说明不是同构的
      if (!Objects.equals(v1, v2)) {
        return false;
      }
      m1.put(c1, v1);
      m2.put(c2, v2);
    }
    return true;
  }
}
