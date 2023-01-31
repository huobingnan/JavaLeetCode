package leetcode;

import leetcode.runner.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AC(time = "32 ms", memory = "58 MB", timeRank = "54%", memoryRank = "9%")
@Outline(name = "统计一个数组中好对子的数目", description = "模拟, 公式变换", level = ProblemLevel.MEDIUM)
public class L1814 {

    private int rev(int num) {
        int ans = 0;
        for (;;) {
            if (num == 0) break;
            ans *= 10; ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    @LeetCodeTest
    public int countNicePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] -rev(nums[i]);
        }
        final Map<Integer, Integer> count = new HashMap<>();
        for (final int num : nums) {
            final int c = count.getOrDefault(num, 0);
            count.put(num, c+1);
        }
        return (int) (count.values().stream()
                .mapToLong(Long::valueOf)
                .map(x -> x * (x - 1) / 2)
                .reduce(0, Long::sum) % 1000000007);
    }


    public static void main(String[] args) {
        LeetCodeCaseRunner.run(L1814.class);
    }
}
