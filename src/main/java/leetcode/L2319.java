package leetcode;


import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;


@AC(time = "1 ms", memory = "42.4 MB", timeRank = "99.60%", memoryRank = "37.35%")
@Outline(name = "判断一个矩阵是否是X矩阵", description = "模拟", level = ProblemLevel.EASY)
public class L2319 {

    public boolean checkXMatrix(int[][] grid) {
        final int dim = grid.length;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == j) {
                    if (grid[i][j] == 0) return false;
                    else continue;
                } else if (i +j == dim-1) {
                    if (grid[i][j] == 0) return false;
                    else continue;
                } else {
                    if (grid[i][j] != 0) return false;
                    else continue;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final boolean res = new L2319().checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}});
        System.out.println(res);
    }
}
