package tree;

public class BinarySearchTree {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    if (root.val == val) return root;
    if (val < root.val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }
}
