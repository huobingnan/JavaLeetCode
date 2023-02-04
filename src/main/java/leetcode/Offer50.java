package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;

@Outline(name = "剑指 Offer 50. 第一个只出现一次的字符", description = "打表", level = ProblemLevel.EASY)
public class Offer50 {

    @AC(time = "4 ms", memory = "41.7 MB", timeRank = "91.66%", memoryRank = "81.84%")
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        final int[] pos = new int[26];
        Arrays.fill(pos, s.length());
        final int[] cnt = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            final char c = s.charAt(i);
            final int idx = c - 'a';
            if (i < pos[idx]) pos[idx] = i;
            cnt[idx]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1 && pos[i] < res) res = pos[i];
        }
        if (res == Integer.MAX_VALUE) return ' ';
        return s.charAt(res);
    }

    public static void main(String[] args) {
        new Offer50().firstUniqChar("leetcode");
    }
}
