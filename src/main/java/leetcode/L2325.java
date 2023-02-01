package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

import java.util.Arrays;

@AC(time = "2 ms", memory = "40.4 MB", timeRank = "91.61%", memoryRank = "92.70%")
@Outline(name = "2325. 解密消息", description = "模拟, 打表", level = ProblemLevel.EASY)
public class L2325 {
    public String decodeMessage(String key, String message) {
        final boolean[] close = new boolean[26];
        Arrays.fill(close, false);
        final int[] offset = new int[26];
        int cursor = 0;
        for (int i = 0, len = key.length(); i< len; i++) {
            final char c = key.charAt(i);
            if (c == ' ' || close[c-'a']) continue;
            offset[c-'a'] = cursor;
            close[c-'a'] = true;
            cursor++;
        }

        final char[] msg = message.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            final char oc = msg[i];
            if (oc == ' ') continue;
            msg[i] = (char)('a' + offset[oc-'a']);
        }
        return String.valueOf(msg);
    }

    public static void main(String[] args) {
        new L2325().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }
}
