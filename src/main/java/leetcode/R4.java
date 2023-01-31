package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AC(time = "1 ms", memory = "39.2 MB", timeRank = "58.13%", memoryRank = "67.06%")
@Outline(name = "面试题 01.04. 回文排列", description = "打表, 字符串", level = ProblemLevel.EASY)
public class R4 {

    public boolean canPermutePalindrome(String s) {
        final Map<Character, Integer> table = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            table.compute(s.charAt(i), (k, v) -> v == null ? 1 : v+1);
        }
        if (s.length() % 2 == 0) {
            for (final int value : table.values()) {
                if (value % 2 != 0) return false;
            }
            return true;
        } else {
            int oddCount = 0;
            for (final int value : table.values()) {
                if (value % 2 != 0) oddCount++;
            }
            return oddCount == 1;
        }
    }
}
