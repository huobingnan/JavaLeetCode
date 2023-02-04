package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@Outline(name = "剑指 Offer 04. 二维数组中的查找", description = "二分查找, 矩阵", level = ProblemLevel.MEDIUM)
public class Offer04 {

    @AC(time = "0 ms", memory = "47.6 MB", timeRank = "100%", memoryRank = "15.04%")
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // boundary case
        if (matrix == null || matrix.length == 0) return false;
        int x = 0, y = matrix[0].length-1;
        for (;;) {
            if (y < 0 || x >= matrix.length) break;
            final int cur = matrix[x][y];
            if (cur == target) return true;
            else if (cur > target) y--;
            else x++;
        }
        return false;
    }
}
