package dp;

/**
 * @author victorcheng Created: 2020/2/24 14:14
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
  public int maxSubArray(int[] nums) {
    if (nums == null) return 0;
    if (nums.length <= 1) return nums[0];
    int length = nums.length;
    int[] dp = new int[length];
    dp[0] = nums[0];
    for (int i = 1; i < length; i ++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    }
    int max = 0;
    for (int i = 0; i < length; i ++) {
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return max;
  }

  public int maxSumOfSubArray(int[] nums) {
    int max = Integer.MIN_VALUE, cur = 0;

    for (int i = 0; i < nums.length; ++i) {
      cur = cur <= 0 ? nums[i] : (cur + nums[i]);
      max = Math.max(max, cur);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, -8, 3, -2, 4, -10};
    System.out.println(new MaxSubArray().maxSubArray(nums));
  }
}
