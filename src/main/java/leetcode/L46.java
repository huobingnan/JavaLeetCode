package leetcode;

import leetcode.runner.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AC(time = "4 ms", memory = "41.7 MB", timeRank = "3%", memoryRank = "58%")
@Outline(name = "全排列", description = "全排列, 递归", level = ProblemLevel.MEDIUM)
public class L46 {

    private void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void doPermuteRecursion(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length-2) {
            result.add(Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
            swap(nums, start, start+1);
            result.add(Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
            swap(nums, start, start+1);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            doPermuteRecursion(nums, start+1, result);
            swap(nums, start, i);
        }
    }

    @LeetCodeTest
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        doPermuteRecursion(nums, 0, result);
        return result;
    }


    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L46.class);
    }
}
