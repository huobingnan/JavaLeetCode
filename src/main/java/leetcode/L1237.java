package leetcode;

import leetcode.infra.CustomFunction;
import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;
import leetcode.runner.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@URL("https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation")
@Outline(name = "1237. 找出给定方程的正整数解", description = "沿着梯度的方向枚举", level = ProblemLevel.MEDIUM)
public class L1237 {

    // 目标函数定义为 J(x, y) = f(x, y) - z, J(x, y) = 0
    //  已知：f(x+1, y) - f(x, y) > 0 并且 f(x, y+1) - f(x, y) > 0, 即函数f在沿x轴方向递增，沿y轴方向也递增
    @AC(time = "1 ms", memory = "39.7 MB", timeRank = "92.44%", memoryRank = "8.4%")
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // x, y 取值的边界为 [1, 1000]
        int x = 1, y = 1;
        final List<List<Integer>> res = new ArrayList<>();
        for (;;) {
            for (;;) {
                final int j = customfunction.f(x, y) - z;
                if (j > 0) break;
                if (j == 0) res.add(Arrays.asList(x, y));
                x++;
                if (x > 1000) break;
            }
            y++; x = 1;
            final int r = customfunction.f(x, y) - z;
            if (r > 0) break;
        }
        return res;
    }
}
