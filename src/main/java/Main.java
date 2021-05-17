import java.util.HashMap;
import java.util.Map;

/**
 * @author victorcheng Created: 2019-08-08 19:32
 */
public class Main {
  public static void main(String[] args) {
    Map<Long, String> map = new HashMap<>();
    map.put(1L, "1");
    System.out.println(map.get((long)1));
  }
}
