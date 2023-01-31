package leetcode;

import leetcode.runner.*;

import java.util.*;

@AC(time = "315 ms", memory = "57.9 MB", memoryRank = "67%")
@Outline(name = "最长连续序列", description = "打表", level = ProblemLevel.MEDIUM)
public class L128 {

    @LeetCodeTest
    public int longestConsecutive(int[] nums) {
        final Set<Integer> hasPresent = new HashSet<>();
        Arrays.stream(nums).forEach(hasPresent::add);
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cur = 1;
            if (!hasPresent.contains(num-1)) {
                while (hasPresent.contains(num+1)) {
                    num++; cur++;
                }
                longest = Math.max(longest, cur);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L128.class);
    }
}
