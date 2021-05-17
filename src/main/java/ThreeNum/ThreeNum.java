package ThreeNum;

import java.util.*;

public class ThreeNum {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Map<Integer, Integer> lookup = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      lookup.put(-nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int key = nums[i] + nums[j];
        if (lookup.containsKey(key)) {
          int k = lookup.get(key);
          if (k != i && k != j) {
            List<Integer> tuple = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(tuple);
            result.add(tuple);
          }
        }
      }
    }
    return new ArrayList<>(result);
  }
}
