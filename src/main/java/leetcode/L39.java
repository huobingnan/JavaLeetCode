package leetcode;

import leetcode.runner.LeetCodeCaseRunner;
import leetcode.runner.LeetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {

    public void doCombinationSumRecursion(int[] candidates, int target, List<List<Integer>> result,
                                          List<Integer> collector) {
        for (int i = 0; i < candidates.length; i++) {
        }
    }

    @LeetCodeTest
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> result = new ArrayList<>();
        doCombinationSumRecursion(candidates, target, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L39.class);
    }
}
