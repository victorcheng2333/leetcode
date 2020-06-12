package tree;

public class SortedArrayToBST {

  private TreeNode recursiveHelp(int[] nums, int start, int end) {
    if (start > end) return null;
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = recursiveHelp(nums, start, end - 1);
    root.right = recursiveHelp(nums, mid + 1, end);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return recursiveHelp(nums, 0, nums.length-1);
  }
}
