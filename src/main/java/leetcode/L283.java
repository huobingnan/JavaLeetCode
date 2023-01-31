package leetcode;

import leetcode.runner.*;

import java.util.Arrays;

@AC(time = "1 ms", memory = "43.2 MB", timeRank = "100%", memoryRank = "16%")
@Outline(name = "移动零", description = "数组删除元素", level = ProblemLevel.EASY)
public class L283 {

    @LeetCodeTest
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k++;
            else nums[i-k] = nums[i];
        }
        for (int i = nums.length-k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L283.class);
    }
}
