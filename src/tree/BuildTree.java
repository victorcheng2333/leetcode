package tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BuildTree {

  private TreeNode buildTree(
      int[] post, int postStart, int postEnd,
      int inStart, Map<Integer, Integer> inPosMap) {
    if (postStart > postEnd) return null;
    TreeNode root = new TreeNode(post[postEnd]);
    int rootIdx = inPosMap.get(root.val);
    int leftLen = rootIdx - inStart;
    root.left = buildTree(post, postStart, postStart+leftLen-1, inStart, inPosMap);
    root.right = buildTree(post, postStart+leftLen, postEnd-1, rootIdx+1, inPosMap);
    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map<Integer, Integer> inPosMap = new HashMap<>();
    for (int i = 0; i < inorder.length; ++i)
      inPosMap.put(inorder[i], i);
    return buildTree(postorder, 0, postorder.length-1, 0, inPosMap);
  }
}
