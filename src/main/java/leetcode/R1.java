package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;
import java.util.Set;

@AC(time = "0 ms", memory = "39.6 MB", timeRank = "100%", memoryRank = "5.16%")
@Outline(name = "面试题 01.01. 判定字符是否唯一", description = "打表", level = ProblemLevel.EASY)
public class R1 {

    public boolean isUnique(String astr) {
        final boolean[] close = new boolean[26];
        Arrays.fill(close, false);
        final char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final int pos = chars[i] - 'a';
            if (close[pos]) return false;
            else close[pos] = true;
        }
        return true;
    }
}
