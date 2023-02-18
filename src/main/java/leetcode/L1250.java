package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

@URL("https://leetcode.cn/problems/check-if-it-is-a-good-array/")
@Outline(name = "1250. 检查「好数组」", description = "数论, 裴蜀定理, 互质, 最大公因数", level = ProblemLevel.HARD)
public class L1250 {

    public int gcd(final int a, final int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (;;) {
            final int remnant = max % min;
            if (remnant == 0) {
                return min;
            } else {
                max = min;
                min = remnant;
            }
        }
    }

    // 本题主要考察一些数论的知识，涉及到"裴蜀定理"的一些应用
    //  算法实现上，需要借助求解两数最大公因数的算法
    @AC(time = "3 ms", memory = "50.6 MB")
    public boolean isGoodArray(int[] nums) {
        int d = nums[0];
        for (final int num : nums) {
            d = gcd(d, num);
            if (d == 1) break;
        }
        return d == 1;
    }
}
