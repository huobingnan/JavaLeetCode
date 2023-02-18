package leetcode;

import leetcode.infra.TreeNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.LinkedList;
import java.util.Queue;

@Outline(name = "剑指 Offer 27. 二叉树的镜像", description = "二叉树, 遍历", level = ProblemLevel.EASY)
public class Offer27 {

    @AC(time = "0 ms", memory = "39.1 MB", timeRank = "100%", memoryRank = "30.78%")
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // 使用二叉树的广度优先遍历
        final Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (;;) {
            if (q.isEmpty()) break;
            final TreeNode n = q.poll();
            final TreeNode temp = n.left;
            n.left = n.right;
            n.right = temp;
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        return root;
    }
}
