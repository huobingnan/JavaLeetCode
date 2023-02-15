package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayDeque;
import java.util.Deque;

@Outline(name = "剑指 Offer 28. 对称的二叉树", description = "二叉树, 递归", level = ProblemLevel.EASY)
public class Offer28 {

    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) {
            if (p.val != q.val) return false;
            return checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
        } else {
            return false;
        }
    }

    @AC(time = "0 ms", memory = "39.6 MB", timeRank = "100%", memoryRank = "59.74%")
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
}
