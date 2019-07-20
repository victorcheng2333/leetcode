package MergeBinaryTree;

/**
 * @Author: victorcheng
 * @Date: 2019-07-17 23:46
 * @Description: https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return mergeNode(t1, t2);
  }

  // 递归 merge 两个树节点
  public static TreeNode mergeNode(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode newNode = new TreeNode(t1.val + t2.val);
    newNode.left = mergeNode(t1.left,t2.left);
    newNode.right = mergeNode(t1.right,t2.right);
    return newNode;
  }
}
