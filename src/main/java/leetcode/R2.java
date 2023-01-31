package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AC(time = "0 ms", memory = "39.4 MB", timeRank = "100%", memoryRank = "40.68%")
@Outline(name = "面试题 01.02. 判定是否互为字符重排", description = "打表", level = ProblemLevel.EASY)
public class R2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        final int length = s1.length();
        final int[] tables = new int[26];
        Arrays.fill(tables, 0);
        for (int i = 0; i < length; i++) {
            tables[s1.charAt(i)-'a']++;
            tables[s2.charAt(i)-'a']--;
        }
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] != 0) return false;
        }
        return true;
    }
}
