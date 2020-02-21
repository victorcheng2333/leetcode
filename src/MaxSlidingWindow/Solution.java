package MaxSlidingWindow;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author victorcheng Created: 2020/2/20 15:21
 */
public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return new int[]{};

    int len = nums.length;
    int[] result = new int[len - k + 1];
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
    for (int i = 0; i < k; i++) {
      queue.add(nums[i]);
    }
    result[0] = queue.peek();
    for (int i = k; i < len; i ++) {
      queue.remove(nums[i - k]);
      queue.add(nums[i]);
      result[i - k + 1] = queue.peek();
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
    System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, 3)));
  }

}
