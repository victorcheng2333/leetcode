package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 */
public class BinaryTreeTraversal {
    class ColorNode {
        TreeNode node;
        Integer color;

        public ColorNode(TreeNode node,Integer color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        final Integer WHITE = 0;
        final Integer GRAY = 1;
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,WHITE));
        while(!stack.empty()){
            ColorNode cn = stack.pop();
            if(cn.color.equals(WHITE)){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,WHITE));
                stack.push(new ColorNode(cn.node, GRAY));
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,WHITE));
            }else{
                res.add(cn.node.val);
            }
        }
        return res;
    }
}
