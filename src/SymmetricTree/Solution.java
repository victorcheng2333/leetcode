package SymmetricTree;

/**
 * @author victorcheng Created: 2020/2/20 10:00
 */
public class Solution {
  // 递归解法
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
  }

  // 递归 helper 函数
  boolean isMirror(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;

    if (left == null || right == null || left.val != right.val) return false;

    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);

    System.out.println(new Solution().isSymmetric(root));
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
