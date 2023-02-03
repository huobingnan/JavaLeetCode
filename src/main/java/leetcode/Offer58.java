package leetcode;

import leetcode.runner.AC;
import leetcode.runner.Outline;
import leetcode.runner.ProblemLevel;

@AC(time = "1 ms", memory = "41.5 MB", timeRank = "61.12%", memoryRank = "39.04%")
@Outline(name = "剑指 Offer 58 - II. 左旋转字符串", description = "字符串, 左移", level = ProblemLevel.EASY)
public class Offer58 {

    void reverseBetween(char[] arr, int left, int right) {
        for (; left < right; left+=1, right-=1) {
            final char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public String reverseLeftWords(String s, int n) {
        final char[] chs = s.toCharArray();
        reverseBetween(chs, 0, n-1);
        reverseBetween(chs, n, chs.length-1);
        reverseBetween(chs, 0, chs.length-1);
        return String.valueOf(chs);
    }
}
