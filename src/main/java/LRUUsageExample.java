/**
 * @Author: victorcheng Created 2019-06-25 17:12
 */
public class LRUUsageExample {
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    printCache(1, cache.get(1));
    cache.put(3, 3);
    printCache(2, cache.get(2));
    cache.put(4, 4);
    printCache(1, cache.get(1));
  }

  private static void printCache(int key, int cache) {
    if (cache == -1) {
      System.out.println("get no cache for key:" + key);
    } else {
      System.out.println("get cache:" + cache + " for key:" + key);
    }
  }
}
