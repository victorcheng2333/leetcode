package MergeBinaryTree;

/**
 * @Author: victorcheng
 * @Date: 2019-07-17 23:46
 * @Description:
 */
public class TestExample {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    node1.left = new TreeNode(3);
    node1.left.left = new TreeNode(5);
    node1.right = new TreeNode(2);
    recursionPreOrderTraversal(node1);

    System.out.println("");

    TreeNode node2 = new TreeNode(2);
    node2.left = new TreeNode(1);
    node2.left.right = new TreeNode(4);
    node2.right = new TreeNode(3);
    node2.right.right = new TreeNode(7);

    recursionPreOrderTraversal(node2);

    System.out.println("");

    Solution solution = new Solution();
    TreeNode mergedNode = solution.mergeTrees(node1, node2);
    recursionPreOrderTraversal(mergedNode);

  }

  // 深度优先 ，先遍历
  private static void recursionPreOrderTraversal(TreeNode treeNode) {
    if (treeNode != null) {
      System.out.print(treeNode.val + " ");
      recursionPreOrderTraversal(treeNode.left);
      recursionPreOrderTraversal(treeNode.right);
    }
  }
}
