package leetcode;

import leetcode.infra.TreeNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayDeque;
import java.util.Queue;

@Outline(name = "剑指 Offer 32 - I. 从上到下打印二叉树", description = "二叉树的层序遍历", level = ProblemLevel.MEDIUM)
public class Offer32 {

    @AC(time = "1 ms", memory = "39.9 MB", timeRank = "96.96%", memoryRank = "99.63%")
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        final Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int scale = 0, cursor = 0;
        for (;;) {
            if (q.isEmpty()) break;
            final TreeNode n = q.poll();
            scale++;
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        final int[] r = new int[scale];
        q.offer(root);
        for (;;) {
            if (q.isEmpty()) break;
            final TreeNode n = q.poll();
            r[cursor++] = n.val;
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);   r[cursor++] = n.val;
        }
        return r;
    }
}
