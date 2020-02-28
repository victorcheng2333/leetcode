package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author victorcheng Created: 2020/2/24 17:57
 */
public class BinaryTreeLevelOrderTravel {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelValues = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        levelValues.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      result.add(levelValues);
    }
    for (int i = 0; i < result.size() / 2; i ++) {
      int j = result.size() - 1 - i;
      List<Integer> tmp = result.get(i);
      result.set(i, result.get(j));
      result.set(j, tmp);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(16);

    List<List<Integer>> result = new BinaryTreeLevelOrderTravel().levelOrderBottom(root);
    result.forEach(System.out::println);
  }
}

