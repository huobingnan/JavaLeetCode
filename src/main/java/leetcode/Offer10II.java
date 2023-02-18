package leetcode;

import leetcode.runner.*;


@SeeAlso("https://leetcode-cn.com/problems/climbing-stairs/")
@URL("https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof")
@Outline(name = "剑指 Offer 10- II. 青蛙跳台阶问题", description = "动态规划, 递归", level = ProblemLevel.EASY)
public class Offer10II {

    // 小青蛙跳台阶问题本质上与斐波那契数列无异，小青蛙一次可以跳1个台阶或者2个台阶
    //   1. 定义青蛙要跳上第0个台阶的方式只有1种
    //   2. 显然，青蛙跳上第1个台阶的方式也只有1种，即一次跳一个台阶到达第一台阶。
    //   3. 不难看出，青蛙跳上第2个台阶的方式数目 = 青蛙跳上第0个台阶的方式数目 + 青蛙跳上第1个台阶的方式数目
    //   4. 因此可以总结出： f(N) = f(N-1) + f(N-2), 这正是斐波那契数列的递归定义式
    @AC(time = "0 ms", memory = "38.5 MB", timeRank = "100%", memoryRank = "20.78%")
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int first = 1, second = 1, t = 0;
        for (int i = 2; i < n; i++) {
            t = second;
            second = (first + second)%1000000007; // 防止数目过大，进行取模运算
            first = t;
        }
        return second;
    }
}
