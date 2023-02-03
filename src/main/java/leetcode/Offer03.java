package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.HashSet;
import java.util.Set;

@AC(time = "1 ms", memory = "49 MB", timeRank = "77.88%", memoryRank = "61.84%")
@Outline(name = "剑指 Offer 03. 数组中重复的数字", description = "打表", level = ProblemLevel.EASY)
public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        final boolean[] close = new boolean[nums.length];
        for (final int num : nums) {
            if (close[num]) return num;
            close[num] = true;
        }
        return -1;
    }
}
