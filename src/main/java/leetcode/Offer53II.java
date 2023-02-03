package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.stream.IntStream;

@AC(time = "2 ms", memory = "41.9 MB", timeRank = "5.81%", memoryRank = "94.66%")
@Outline(name = "剑指 Offer 53 - II. 0～n-1中缺失的数字", description = "数列求和", level = ProblemLevel.EASY)
public class Offer53II {

    public int missingNumber(int[] nums) {
        final int n = nums.length+1;
        final int expect = n * (n + 1)  / 2;
        final int actual = IntStream.of(nums).reduce(0, Integer::sum);
        return expect - actual;
    }
}
