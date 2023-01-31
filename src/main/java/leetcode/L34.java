package leetcode;

import leetcode.runner.*;

import java.util.Arrays;

@AC(time = "0 ms", memory = "44.7 MB", timeRank = "100%", memoryRank = "49%")
@Outline(name = "在排序数组中查找元素的第一个和最后一个位置", description = "二分查找", level = ProblemLevel.MEDIUM)
public class L34 {

    @LeetCodeTest
    public int[] searchRange(int[] nums, int target) {
        final int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            // 未找到
            return new int[] {-1, -1};
        } else {
            int i = index;
            int j = index;
            for (; i < nums.length; i++) {
                if (nums[i] != target) break;
            }
            for (; j >= 0; j--) {
                if (nums[j] != target) break;
            }
            return new int[] {j+1, i-1};
        }
    }

    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L34.class);
    }
}
