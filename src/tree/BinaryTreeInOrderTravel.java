package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTravel {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    travelHelper(root, result);
    return result;
  }

  void travelHelper(TreeNode node, List<Integer> result) {
    if (node == null) return;
    travelHelper(node.left, result);
    result.add(node.val);
    travelHelper(node.right, result);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(16);

    List<Integer> result = new BinaryTreeInOrderTravel().inorderTraversal(root);
    System.out.println(result);
  }

}
