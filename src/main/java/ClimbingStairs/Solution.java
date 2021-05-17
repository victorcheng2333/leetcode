package ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private Map<Integer, Integer> mem;
  // 递归的方法
  // 直接递归， 计算次数太多
  // 通过 map 优化
  public int climbStairs(int n) {
    mem = new HashMap<>();
    return climbHelper(n);

  }

  int climbHelper(int n) {
    if (n <= 2) return n;
    int oneStep = mem.containsKey(n - 1) ? mem.get(n - 1) : climbHelper(n - 1);
    int twoStep = mem.containsKey(n - 2) ? mem.get(n - 2) : climbHelper(n - 2);

    int data = oneStep + twoStep;
    mem.put(n, data);
    return data;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(60));
  }
}
