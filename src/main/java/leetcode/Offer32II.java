package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.*;

@Outline(name = "剑指 Offer 32 - II. 从上到下打印二叉树 II", description = "二叉树的层序遍历", level = ProblemLevel.EASY)
public class Offer32II {


    @AC(time = "1 ms", memory = "41.7 MB", timeRank = "72.1%", memoryRank = "31.1%")
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        final List<List<Integer>> r = new ArrayList<>();
        final Queue<TreeNode> q = new ArrayDeque<>();
        final Queue<Integer> l = new ArrayDeque<>();

        int cl = 0;
        List<Integer> collector = new ArrayList<>();
        q.offer(root); l.offer(1);
        for (;;) {
            if (q.isEmpty()) break;
            final TreeNode node = q.poll();
            final int level = l.poll();
            if (level != cl && !collector.isEmpty()) {
                r.add(collector);
                collector = new ArrayList<>();
                cl = level;
            }
            collector.add(node.val);
            // 扩展
            if (node.left != null) {
                q.offer(node.left);
                l.offer(level+1);
            }
            if (node.right != null) {
                q.offer(node.right);
                l.offer(level+1);
            }
        }
        if (!collector.isEmpty()) r.add(collector);
        return r;
    }

}
