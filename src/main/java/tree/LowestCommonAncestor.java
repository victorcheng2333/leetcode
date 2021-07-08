package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    // 搜索并获取从根节点至目标节点的一条路径
    boolean search(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean ret = search(root.left, node, path) || search(root.right, node, path);
        if (ret) {
            return true;
        } else {
            path.remove(path.size()-1);
            return false;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var pPath = new ArrayList<TreeNode>();
        var qPath = new ArrayList<TreeNode>();
        search(root, p, pPath);
        search(root, q, qPath);
        var i = 0;
        var len = Math.min(pPath.size(), qPath.size());
        while (i < len && pPath.get(i) == qPath.get(i)) ++i;
        return pPath.get(i-1);
    }
}
