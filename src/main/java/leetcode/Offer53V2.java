package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "0 ms", memory = "44.5 MB", timeRank = "100%", memoryRank = "41.80%")
@Outline(name = "剑指 Offer 53 - I. 在排序数组中查找数字 I", description = "枚举", level = ProblemLevel.EASY)
public class Offer53V2 {

    public int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (num > target) break;
            else if (num == target) count++;
        }
        return count;
    }

}
