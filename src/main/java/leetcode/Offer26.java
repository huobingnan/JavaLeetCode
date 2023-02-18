package leetcode;

import leetcode.infra.TreeNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

@Outline(name = "剑指 Offer 26. 树的子结构", description = "二叉树, 模拟", level = ProblemLevel.MEDIUM)
public class Offer26 {

    public boolean check(TreeNode a, TreeNode b) {
        final Deque<TreeNode> stkA = new LinkedList<>();
        final Deque<TreeNode> stkB = new LinkedList<>();
        stkA.push(a); stkB.push(b);
        for (;;) {
            if (stkA.isEmpty() || stkB.isEmpty()) break;
            final TreeNode pa = stkA.pop();
            final TreeNode pb = stkB.pop();

            if (pa == null && pb != null) return false;
            else if (pa != null && pb == null) continue;
            else if (pa == null && pb == null) continue;

            if (pa.val != pb.val) { return false; }
            stkA.push(pa.right); stkB.push(pb.right);
            stkA.push(pa.left); stkB.push(pb.left);
        }
        return stkB.isEmpty();
    }

    @AC(time = "5 ms", memory = "43.3 MB", timeRank = "2.73 %", memoryRank = "93.24%")
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(A);
        for (;;) {
            if (stk.isEmpty()) break;
            final TreeNode p = stk.pop();
            if (p.val == B.val) {
                if (check(p, B)) return true;
            }
            if (p.right != null) stk.push(p.right);
            if (p.left != null) stk.push(p.left);
        }
        return false;
    }
}
