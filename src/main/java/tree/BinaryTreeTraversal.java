package tree;

import org.javatuples.Pair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        final var WHITE = 0;
        final var GRAY = 1;
        var stack = new LinkedList<Pair<Integer, TreeNode>>();
        stack.push(Pair.with(WHITE, root));
        while (!stack.isEmpty()) {
            var pair = stack.pop();
            var color = pair.getValue0();
            var node = pair.getValue1();
            if (node == null) continue;
            if (color == WHITE) {
                stack.add(Pair.with(WHITE, node.right));
                stack.add(Pair.with(GRAY, node));
                stack.add(Pair.with(WHITE, node.left));
            } else {
                result.add(node.val);
            }
        }
        return result;
    }
}
