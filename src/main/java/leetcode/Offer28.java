package leetcode;

import leetcode.infra.TreeNode;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

@URL("https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/")
@Outline(name = "剑指 Offer 28. 对称的二叉树", description = "二叉树, 递归", level = ProblemLevel.EASY)
public class Offer28 {

    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) {
            if (p.val != q.val) return false;
            // 递归剪枝
            final boolean one = checkSymmetric(p.left, q.right);
            if (one) return checkSymmetric(p.right, q.left);
            else return false;
        } else {
            return false;
        }
    }

    @AC(time = "0 ms", memory = "39.4 MB", timeRank = "100%", memoryRank = "93.36%")
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
}
