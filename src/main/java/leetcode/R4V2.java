package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AC(time = "0 ms", memory = "39.2 MB", timeRank = "100%", memoryRank = "67.06%")
@Outline(name = "面试题 01.04. 回文排列", description = "打表, 字符串", level = ProblemLevel.EASY)
public class R4V2 {
    public boolean canPermutePalindrome(String s) {
        final Set<Character> table = new HashSet<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            final char c = s.charAt(i);
            if (table.contains(c)) table.remove(c);
            else table.add(c);
        }
        if (s.length() % 2 == 0) return table.isEmpty();
        else return table.size() == 1;
    }
}
