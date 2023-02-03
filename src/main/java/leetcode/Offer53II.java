package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.stream.IntStream;

@Outline(name = "剑指 Offer 53 - II. 0～n-1中缺失的数字", description = "数列求和, 枚举", level = ProblemLevel.EASY)
public class Offer53II {


    @AC(time = "0 ms", memoryRank = "42 MB", timeRank = "100%", memory = "74.88%")
    public int missingNumberV2(int[] nums) {
        // 枚举
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return i;
    }

    @AC(time = "2 ms", memory = "41.9 MB", timeRank = "5.81%", memoryRank = "94.66%")
    public int missingNumber(int[] nums) {
        // 数学 数列求和
        final int n = nums.length+1;
        final int expect = n * (n + 1)  / 2;
        final int actual = IntStream.of(nums).reduce(0, Integer::sum);
        return expect - actual;
    }
}
