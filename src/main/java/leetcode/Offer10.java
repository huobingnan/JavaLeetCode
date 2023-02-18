package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

@URL("https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/")
@Outline(name = "剑指 Offer 10- I. 斐波那契数列", description = "动态规划, 递归", level = ProblemLevel.EASY)
public class Offer10 {

    // 迭代法求解斐波那契数列
    @AC(time = "0 ms", memory = "38 MB", timeRank = "100%", memoryRank = "90.69%")
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int first = 1, second = 1, t = 0;
        for (int i = 2; i < n; i++) {
            t = second;
            second = (first + second)%1000000007; // 防止数目过大，进行取模运算
            first = t;
        }
        return second;
    }
}
