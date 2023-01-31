package leetcode;

import leetcode.runner.*;

import java.util.Arrays;

@AC(time = "55 ms", memory = "40.6 MB", timeRank = "74%", memoryRank = "100%")
@Outline(name = "最长递增子序列", description = "动态规划", level = ProblemLevel.MEDIUM)
public class L300 {

    @LeetCodeTest
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        for (int j = nums.length-1; j >= 0; j--) {
            final int cur = nums[j];
            int i = j; int max = 0, c = i;
            for (; i < nums.length; i++) {
                // 找到比 cur 大且 dp 值也最大
                if (nums[i] - cur > 0 && dp[i] > max) {
                    max = dp[i]; c = i;
                }
            }
            dp[j] = dp[c] + 1;
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L300.class);
    }
}
