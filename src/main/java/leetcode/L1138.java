package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@Outline(name = "1138. 字母板上的路径", description = "模拟, 矩阵, 曼哈顿距离", level = ProblemLevel.MEDIUM)
public class L1138 {

    @AC(time = "0 ms", memory = "39.4 MB", timeRank = "100%", memoryRank = "77.38%")
    public String alphabetBoardPath(String target) {
        final int[][] pos = new int[][] {
                // a - e
                {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
                // f - j
                {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
                // k - o
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
                // p - t
                {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
                // u - y
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                // z
                {5, 0}
        };

        // 使用曼哈顿距离： 先解决垂直距离，再解决水平距离
        int x = 0, y = 0, i = 0, len = target.length();
        final StringBuilder sb = new StringBuilder();
        for (;;) {
            if (i == len) break;
            final char c = target.charAt(i);
            final int offset = c - 'a';
            int dx = pos[offset][0] - x;
            int dy = pos[offset][1] - y;

            // 检查是否越界
            if (y > 0 && x + dx >= 5) {
                dx = 0;
            }

            for (int j = 0; j < Math.abs(dx); j++) {
                if (dx > 0) sb.append('D');
                else sb.append('U');
            }

            for (int j = 0; j < Math.abs(dy); j++) {
                if (dy > 0) sb.append('R');
                else sb.append('L');
            }
            x += dx; y += dy;
            if (x*5+y == offset) {
                sb.append('!');
                i++;
            }
        }
        return sb.toString();
    }
}
