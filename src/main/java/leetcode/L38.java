package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.ArrayList;
import java.util.List;

@Outline(name = "38. 外观数列", description = "递归, 自指悖论", level = ProblemLevel.MEDIUM)
public class L38 {
    @AC(time = "3 ms", memory = "41.4 MB", timeRank = "69.69%", memoryRank = "28.83%")
    public String countAndSay(int n) {
        // 在外观序列这种，数字4永远不会出现
        if (n == 1) {
            return "1";
        }
        final String prev = countAndSay(n-1);
        // 描述 n-1
        // 1. 将字符串分割成组： 使用滑动窗口找到最长的连续串
        final List<String> groups = new ArrayList<>();
        int left = 0, right = 1, len = prev.length();
        for (;;) {
            if (right >= len) break;
            if (prev.charAt(right) == prev.charAt(left)) right++;
            else {
                groups.add(prev.substring(left, right));
                left = right; right = left+1;
            }
        }
        groups.add(prev.substring(left, right));
        // 2. 返回当前的描述
        final StringBuilder sb = new StringBuilder();
        for (final String group : groups) {
            sb.append(group.length());
            sb.append(group.charAt(0));
        }
        return sb.toString();
    }


}
